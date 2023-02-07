package com.ivandjoh.javafib.utils;

import com.ivandjoh.javafib.exception.FibOutOfRangeException;
import org.springframework.stereotype.Service;

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
}
