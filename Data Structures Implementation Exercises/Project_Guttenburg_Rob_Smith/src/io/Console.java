package io;

import java.util.Scanner;

public class Console
{
    private Scanner console = new Scanner(System.in);

    public void println(String message)
    {
        System.out.println(message);
    }

    public void print(String message)
    {
        System.out.print(message);
    }

    public void newLine()
    {
        System.out.println();
    }

    public int getInt(String prompt)
    {
        System.out.print(prompt + "");
        while (!console.hasNextInt())
        {
            System.out.println("Please enter a valid integer: ");
            console.nextLine(); //clear the scanner buffer
        }

        int result = console.nextInt();
        console.nextLine(); //clear the scanner buffer

        return result;
    }

}
