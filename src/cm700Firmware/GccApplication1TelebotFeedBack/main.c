//##########################################################
//##                      R O B O T I S                   ##
//## CM-700 (Atmega2561) Example code for Dynamixel.      ##
//##                                           2009.11.10 ##
//##########################################################
//Edited By Curtis Cox
//FIU Discovery Lab

#include <avr/io.h>
#include <avr/interrupt.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define F_CPU 16000000 //16mHZ processor
#include <util/delay.h>


#include "dynamixel.h"
#include "serial.h"

/// Control table address
#define P_STATUS_RETURN_LEVEL	16
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

// Default setting
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
	unsigned short currentPosition[14];
	unsigned short servoIdList[14] = {10, 11, 20, 21, 22, 23, 24, 25, 30, 31, 32, 33, 34, 35};
	int wPresentPos;
	int CommStatus;

	int servoID = 0;
	int servoPosition = 0;
	int servoSpeed = 0;
	int pGain = 1;
	int iGain = 0;
	int dGain = 0;
	int readingData = 0;
	unsigned char ReceivedData;
	
	msgBuf2[0] = '<';
	msgBuf2[3] = ' ';
	msgBuf2[8] = '>';
	msgBuf2[9] = '\0';
	serial_initialize(57600);
	dxl_initialize(0, DEFAULT_BAUDNUM); // Not using device index
	sei();	// Interrupt Enable	
	
//	printf( "\n\nRead/Write example for CM-700\n\n" );
//	printf( "\n\nTeleBot Arm Controller (CM-700) ver-0.1.1 (0819-2013)\n\n" );
//	printf( "\n\nTeleBot Arm Controller (CM-700) ver-0.1.2 (1023-2013)\n\n" );
//	printf( "\n\nTeleBot Arm Controller (CM-700) ver-0.1.3 (1125-2013)\n\n" );
	printf( "\n\nTeleBot Arm Controller (CM-700) ver-0.1.4 (0222-2016)\n\n" );

	for( int i = 0; i < 14; i++)
	{
		servoID = servoIdList[i];
		//Set PID values
		dxl_write_word(servoID, P_PGAIN, pGain);
		_delay_ms(5);
		dxl_write_word(servoID, P_IGAIN, iGain);
		_delay_ms(5);
		dxl_write_word(servoID, P_DGAIN, dGain);
		_delay_ms(5);
		// Set goal speed
		dxl_write_word(servoID, P_GOAL_SPEED_L, SERVO_SPEED_DEFAULT_VALUE);
		_delay_ms(5);
		dxl_write_word(servoID, P_STATUS_RETURN_LEVEL, 1);
		_delay_ms(5);
	}
	
	while(1)
	{	
		ReceivedData = getchar();	
		if(ReceivedData == '#')
		{
			//skip to feedback
		}	
		else if(ReceivedData == '<')
		{
			readingData = 1;
			msgBufPointer = 0;
		}
		else if(ReceivedData == '>')
		{
			readingData = 0;
			msgBuf0[msgBufPointer]='\0';
			memcpy ( msgBuf1, msgBuf0, strlen((char*)msgBuf0) );
			char * pch1;
			char * pch2;
			int cnt = 0;
			pch1 = strtok ((char*)msgBuf0," ");
			while (pch1 != NULL)
			{
				cnt++;
				pch1 = strtok (NULL, " ");
			}
			
			pch2 = strtok ((char*)msgBuf1," ");
			if ( cnt == 1 )
			{
				if(strncmp (pch2,"gn",2)==0)
				{
					printf("cm-700\n");
				}
			}
			else if (cnt == 2)
			{
				servoID = -1;
				servoPosition = -1;
				servoSpeed = -1;
				while (pch2 != NULL)
				{
					if (cnt == 2)
					{
						servoID = atoi(pch2);
					}
					else if (cnt == 1)
					{
						servoPosition = atoi(pch2);
					}
					cnt--;
					pch2 = strtok (NULL, " ");
				}				
				dxl_write_word(servoID, P_GOAL_POSITION_L, servoPosition);
			}
			else if (cnt == 3)
			{
				servoID = -1;
				servoPosition = -1;
				servoSpeed = -1;
				while (pch2 != NULL)
				{
					if (cnt == 3)
					{
						servoID = atoi(pch2);
					}
					else if (cnt == 2)
					{
						servoPosition = atoi(pch2);
					}
					else if (cnt == 1)
					{
						servoSpeed = atoi(pch2);
					}
					cnt--;
					pch2 = strtok (NULL, " ");
				}
				// Set pGain 
				dxl_write_word( servoID, P_PGAIN, P_PGAIN_DEFAULT_VALUE );
				_delay_ms(1);
				// Set goal speed
				dxl_write_word( servoID, P_GOAL_SPEED_L, servoSpeed );
				_delay_ms(1);
				// Set goal position
				dxl_write_word( servoID, P_GOAL_POSITION_L, servoPosition );
			}
			else if (cnt == 4)
			{
				servoID = -1;
				servoPosition = -1;
				servoSpeed = -1;
				pGain = 3;
				while (pch2 != NULL)
				{
					if (cnt == 4)
					{ 
						servoID = atoi(pch2);
					}
					else if (cnt == 3)
					{
						servoPosition = atoi(pch2);
					}
					else if (cnt == 2)
					{
						servoSpeed = atoi(pch2);
					}
					else if (cnt == 1)
					{
						pGain = atoi(pch2);
						if (pGain > 32) pGain = 32;
					}
					cnt--;
					pch2 = strtok (NULL, " ");
				}
				// Set pGain
				dxl_write_word( servoID, P_PGAIN, pGain );
				_delay_ms(1);
				// Set goal speed
				if(servoSpeed != 0)
				{
					dxl_write_word( servoID, P_GOAL_SPEED_L, servoSpeed );
					_delay_ms(1);
				}
				// Set goal position
				dxl_write_word( servoID, P_GOAL_POSITION_L, servoPosition );
				_delay_ms(1);
			}
			
			for(int i = 0; i < MSG_BUF_SIZE; i++)
			{
				msgBuf0[i]=0x00;
				msgBuf1[i]=0x00;
			}
		}
		else
		{			
			if (msgBufPointer >= MSG_BUF_SIZE-1)
			{
				msgBufPointer = 0;
				for(int i = 0; i < MSG_BUF_SIZE; i++) 
				{
					msgBuf0[i]=0x00;
					msgBuf1[i]=0x00;
				}
			}
			msgBuf0[msgBufPointer]=ReceivedData;
			msgBufPointer++;
		}
		
		//send servo positions if they have changed since last check
		if(!readingData)
		{
			for (int j = 0; j<14; j++)
			{
				servoID = servoIdList[j];
				wPresentPos = dxl_read_word(servoID, P_PRESENT_POSITION_L);
				_delay_ms(1);
				CommStatus = dxl_get_result();
				_delay_ms(1);
				if(CommStatus == COMM_RXSUCCESS)
				{
					if(currentPosition[j] != wPresentPos)
					{
						currentPosition[j] = wPresentPos;
						msgBuf2[1] = servoID/10 + '0';
						msgBuf2[2] = servoID%10 + '0';
						msgBuf2[4] = wPresentPos/1000 +'0';
						wPresentPos %= 1000;
						msgBuf2[5] = wPresentPos/100 +'0';
						wPresentPos %= 100;
						msgBuf2[6] = wPresentPos/10 + '0';
						msgBuf2[7] = wPresentPos%10 + '0';
						for(int k = 0; k<10; k++)
							putchar(msgBuf2[k]);
					}
				}
			}
		}		
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

