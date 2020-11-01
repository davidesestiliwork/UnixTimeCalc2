/*
	UnixTimeCalc2 a Unix time calculator
	Copyright (C) 2020 Davide Sestili

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package it.dsestili.unixtimecalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main 
{
	public static void main(String[] args) 
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Type date and time (yyyy-MM-dd-HH-mm-ss): ");
			String str = br.readLine();
			
			String[] dateAndTime = str.split("-");
			if(dateAndTime.length != 6)
			{
				System.out.println("Required: yyyy-MM-dd-HH-mm-ss");
				return;
			}
			
			int year = Integer.parseInt(dateAndTime[0]);
			int month = Integer.parseInt(dateAndTime[1]);
			int day = Integer.parseInt(dateAndTime[2]);
			
			int hour = Integer.parseInt(dateAndTime[3]);
			int minute = Integer.parseInt(dateAndTime[4]);
			int second = Integer.parseInt(dateAndTime[5]);
			
			Calendar d = new GregorianCalendar(year, (month - 1), day, hour, minute, second);
			System.out.println("Unix time: " + (d.getTimeInMillis() / 1000));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
