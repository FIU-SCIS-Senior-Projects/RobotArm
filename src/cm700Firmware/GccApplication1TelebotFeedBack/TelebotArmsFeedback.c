//##########################################################
//##                      R O B O T I S                   ##
//## CM-700 (Atmega2561) Example code for Dynamixel.      ##
//##                                           2009.11.10 ##
//##########################################################

#include <avr/io.h>
#include <avr/interrupt.h>
#include <stdio.h>
#include <string.h>
#include <util/delay.h>


#include "dynamixel.h"
#include "serial.h"

/// Control table address
#define P_GOAL_POSITION_L		30
#define P_GOAL_POSITION_H		31
#define P_PRESENT_POSITION_L	36
#define P_PRESENT_POSITION_H	37
#define P_MOVING				46

#define P_PGAIN		28
#define P_PGAIN_DEFAULT_VALUE 3
#define P_IGAIN		27
#define P_DGAIN		26
#define P_GOAL_SPEED_L		32
#define P_GOAL_SPEED_H		33
#define MSG_BUF_SIZE			128
#define SERVO_SPEED_DEFAULT_VALUE	100

// Defulat setting
#define DEFAULT_BAUDNUM		1 // 1Mbps
#define DEFAULT_ID			1

void PrintCommStatus(int CommStatus);
void PrintErrorCode(void);

unsigned char msgBuf0[MSG_BUF_SIZE];
unsigned char msgBuf1[MSG_BUF_SIZE];
unsigned char msgBuf2[10];
int msgBufPointer = 0;

int gainCounter = 0;


int main(void)
{
	unsigned short GoalPos[2] = {0, 1023};
	//unsigned short GoalPos[2] = {0, 4095}; // for EX series
	int index = 0;
	int id = 1;
	int bMoving, wPresentPos;
	int CommStatus;

	int servoID = 0;
	int servoPosition = 0;
	int servoSpeed = 0;
	int pGain = 3;
	int iGain = 0;
	int dGain = 0;
	int Value = 0;
	msgBuf2[0] = '<';
	msgBuf2[3] = ' ';
	msgBuf2[8] = '>';
	//msgBuf2[9] = '\0';
	serial_initialize(57600);
	dxl_initialize( 0, DEFAULT_BAUDNUM ); // Not using device index
	sei();	// Interrupt Enable	
	
//	printf( "\n\nRead/Write example for CM-700\n\n" );
//	printf( "\n\nTeleBot Arm Controller (CM-700) ver-0.1.1 (0819-2013)\n\n" );
//	printf( "\n\nTeleBot Arm Controller (CM-700) ver-0.1.2 (1023-2013)\n\n" );
	printf( "\n\nTeleBot Arm Controller (CM-700) ver-0.1.3 (1125-2013)\n\n" );

	for( int i = 0; i < 50; i++){
		dxl_write_word( i, P_PGAIN, P_PGAIN_DEFAULT_VALUE );
				// Set goal speed
		_delay_ms(5);
		dxl_write_word( i, P_GOAL_SPEED_L, SERVO_SPEED_DEFAULT_VALUE  );
		_delay_ms(5);
	}
	
	while(1)
	{
		// Check moving done
		/*
		bMoving = dxl_read_byte( id, P_MOVING );
		CommStatus = dxl_get_result();
		if( CommStatus == COMM_RXSUCCESS )
		{
			if( bMoving == 0 )
			{
				// Change goal position
				if( index == 0 )
					index = 1;
				else
					index = 0;

				// Write goal position
				dxl_write_word( id, P_GOAL_POSITION_L, GoalPos[index] );				
			}
			
			PrintErrorCode();
			
			// Read present position
			wPresentPos = dxl_read_word( id, P_PRESENT_POSITION_L );
			printf( "%d   %d\n",GoalPos[index], wPresentPos );
		}
		else
			PrintCommStatus(CommStatus);
		*/
		
		unsigned char ReceivedData = getchar();		
		if(ReceivedData == '<'){
			msgBufPointer = 0;
		}else if(ReceivedData == '>'){
			msgBuf0[msgBufPointer]='\0';
			memcpy ( msgBuf1, msgBuf0, strlen(msgBuf0) );
//			printf("(1) %s-%s\n",msgBuf0,msgBuf1);
			char * pch1;
			char * pch2;
			int cnt = 0;
			pch1 = strtok (msgBuf0," ");
			while (pch1 != NULL){
//				printf ("%d[%s]\n",cnt++,pch1);
				cnt++;
				pch1 = strtok (NULL, " ");
			}
			
			pch2 = strtok (msgBuf1," ");
//			printf("(2) %s-%s\n",msgBuf1,pch2);
			if ( cnt == 1 ){
				if(strncmp (pch2,"gn",2)==0){
					printf("cm-700\n");
				}
			}else if (cnt == 2){
				servoID = -1;
				servoPosition = -1;
				servoSpeed = -1;
				while (pch2 != NULL){
					//					printf ("%d[%s]\n",cnt++,pch2);
					if (cnt == 2){
						servoID = atoi(pch2);
					}else if (cnt == 1){
						servoPosition = atoi(pch2);
					}
					cnt--;
					pch2 = strtok (NULL, " ");
				}				
				dxl_write_word( servoID, P_GOAL_POSITION_L, servoPosition );
				printf("[%d][%d]\n",servoID,servoPosition);
			}else if (cnt == 3){
				servoID = -1;
				servoPosition = -1;
				servoSpeed = -1;
				while (pch2 != NULL){
					//					printf ("%d[%s]\n",cnt++,pch2);
					if (cnt == 3){
						servoID = atoi(pch2);
						}else if (cnt == 2){
						servoPosition = atoi(pch2);
						}else if (cnt == 1){
						servoSpeed = atoi(pch2);
					}
					cnt--;
					pch2 = strtok (NULL, " ");
				}
				//				printf("%d %d %d\n",servoID,servoPosition,servoSpeed);
				// Set pGain 
				dxl_write_word( servoID, P_PGAIN, P_PGAIN_DEFAULT_VALUE );
				_delay_ms(1);
				// Set goal speed
				dxl_write_word( servoID, P_GOAL_SPEED_L, servoSpeed );
				_delay_ms(1);
				// Set goal position
				dxl_write_word( servoID, P_GOAL_POSITION_L, servoPosition );
		
				printf("[%d][%d][%d][%d]\n",servoID,servoPosition,servoSpeed,pGain);
			}else if (cnt == 4){
				servoID = -1;
				servoPosition = -1;
				servoSpeed = -1;
				pGain = 3;
				while (pch2 != NULL){
//					printf ("%d[%s]\n",cnt++,pch2);
					if (cnt == 4){ 
						servoID = atoi(pch2);
					}else if (cnt == 3){
						servoPosition = atoi(pch2);
					}else if (cnt == 2){
						servoSpeed = atoi(pch2);
					}else if (cnt == 1){
						pGain = atoi(pch2);
						if (pGain > 32) pGain = 32;
					}
					cnt--;
					pch2 = strtok (NULL, " ");
				}
//				printf("%d %d %d\n",servoID,servoPosition,servoSpeed);
				// Set pGain
				dxl_write_word( servoID, P_PGAIN, pGain );
				_delay_ms(1);
				// Set goal speed
				dxl_write_word( servoID, P_GOAL_SPEED_L, servoSpeed );
				_delay_ms(1);
				// Set goal position
				dxl_write_word( servoID, P_GOAL_POSITION_L, servoPosition );
				printf("[%d][%d][%d][%d]\n",servoID,servoPosition,servoSpeed,pGain);
			}
			
			for(int i = 0; i < MSG_BUF_SIZE; i++) {
				msgBuf0[i]=0x00;
				msgBuf1[i]=0x00;
			}
//			i = atoi (buffer);
		}else{			
			if (msgBufPointer >= MSG_BUF_SIZE-1){
				msgBufPointer = 0;
				for(int i = 0; i < MSG_BUF_SIZE; i++) {
					msgBuf0[i]=0x00;
					msgBuf1[i]=0x00;
				}
			}
			msgBuf0[msgBufPointer]=ReceivedData;
//			msgBuf1[msgBufPointer]=ReceivedData;
			msgBufPointer++;
		}
		for (int j = 0; j<50; j++)
		{
			wPresentPos = dxl_read_word( j, P_PRESENT_POSITION_L );
			
			msgBuf2[1] = j/10 + '0';
			msgBuf2[2] = j%10 + '0';
			msgBuf2[4] = wPresentPos/1000 +'0';
			msgBuf2[5] = wPresentPos/100 +'0';
			msgBuf2[6] = wPresentPos/10 + '0';
			msgBuf2[7] = wPresentPos%10 + '0';
			for(int k = 0; k<9; k++)
				putchar(msgBuf2[k]);
		}
			
//		printf( "%d   %d\n",GoalPos[index], wPresentPos );

	}

	return 0;
}

// Print communication result
void PrintCommStatus(int CommStatus)
{
	switch(CommStatus)
	{
	case COMM_TXFAIL:
		printf("COMM_TXFAIL: Failed transmit instruction packet!\n");
		break;

	case COMM_TXERROR:
		printf("COMM_TXERROR: Incorrect instruction packet!\n");
		break;

	case COMM_RXFAIL:
		printf("COMM_RXFAIL: Failed get status packet from device!\n");
		break;

	case COMM_RXWAITING:
		printf("COMM_RXWAITING: Now recieving status packet!\n");
		break;

	case COMM_RXTIMEOUT:
		printf("COMM_RXTIMEOUT: There is no status packet!\n");
		break;

	case COMM_RXCORRUPT:
		printf("COMM_RXCORRUPT: Incorrect status packet!\n");
		break;

	default:
		printf("This is unknown error code!\n");
		break;
	}
}

// Print error bit of status packet
void PrintErrorCode()
{
	if(dxl_get_rxpacket_error(ERRBIT_VOLTAGE) == 1)
		printf("Input voltage error!\n");

	if(dxl_get_rxpacket_error(ERRBIT_ANGLE) == 1)
		printf("Angle limit error!\n");

	if(dxl_get_rxpacket_error(ERRBIT_OVERHEAT) == 1)
		printf("Overheat error!\n");

	if(dxl_get_rxpacket_error(ERRBIT_RANGE) == 1)
		printf("Out of range error!\n");

	if(dxl_get_rxpacket_error(ERRBIT_CHECKSUM) == 1)
		printf("Checksum error!\n");

	if(dxl_get_rxpacket_error(ERRBIT_OVERLOAD) == 1)
		printf("Overload error!\n");

	if(dxl_get_rxpacket_error(ERRBIT_INSTRUCTION) == 1)
		printf("Instruction code error!\n");
}

