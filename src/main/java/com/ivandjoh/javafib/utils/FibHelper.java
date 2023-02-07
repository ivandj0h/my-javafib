package com.ivandjoh.javafib.utils;

import com.ivandjoh.javafib.exception.FibInputException;
import com.ivandjoh.javafib.exception.FibOutOfRangeException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FibHelper {

    /**
     * Recursively find the Fibonacci number at the given position
     * @param 'position' the position in the Fibonacci sequence ( i.e. 8th number in the sequence )
     * @return the Fibonacci number at the given position

     * develop by Ivan Djoh
     * february 8, 2023
     */

    public static int execFib(int position) throws FibOutOfRangeException {
        if (position <= 1) {
            return position;
        }
        if (position >= 8) {
            throw new FibOutOfRangeException(String.format("Requested position %s is too large, Please try again.", position));
        }
        return execFib(position - 1) + execFib(position - 2);
    }

    public static List<Integer> getSequence(String str, List<Integer> sequence) throws FibInputException {

        int n;
        try {
            n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new FibInputException(String.format("Input %s is not a number, Please try again.", str));
        }
        if(sequence == null) {
            sequence = new ArrayList<>();
        }
        sequence.add(0);
        int prev = 0;
        int curr = 1;
        int index = 1;
        while(index <= n) {
            sequence.add(curr);
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return sequence;
    }

    public static String writeSequence(List<Integer> fibSequence) throws IOException {

        String filename = "fibonacci-sequence.txt";
        File file = new File(filename);

        // Create the file
        file.createNewFile();

        // Create a FileWriter Object
        FileWriter writer = new FileWriter(file);

        // Write the Content into the file
        writer.write(fibSequence.toString());
        writer.flush();
        writer.close();
        return filename;
    }
}
