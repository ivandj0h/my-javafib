package com.ivandjoh.javafib.controller;

import com.ivandjoh.javafib.exception.FibInputException;
import com.ivandjoh.javafib.exception.FibOutOfRangeException;
import com.ivandjoh.javafib.utils.FibHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/fib")
public class FibController {

    /**
     * Determine the nth Fibonacci number
     *
     * @param "n" position in the Fibonacci number requested
     * @return the nth Fibonacci number in the sequence

     * develop by Ivan Djoh
     * february 8, 2023
     */
    @GetMapping("/find-number")
    public ResponseEntity<String> findFibNumber(@RequestParam int number) {

        int fibNumber;
        try {
            fibNumber = FibHelper.execFib(number);
        } catch (FibOutOfRangeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.ok(String.valueOf(fibNumber));
    }

    /**
     * Store the first n-th number into Fibonacci sequence in text file.
     *
     * @param "n" position in the Fibonacci number requested
     * @return the name of the file where the sequence is stored

     * develop by Ivan Djoh
     * february 8, 2023
     */
    @PostMapping("/create-sequence")
    public ResponseEntity<String> createFibSequence(@RequestParam String number) {

        List<Integer> fibSequence;
        try {
            fibSequence = FibHelper.getSequence(number, null);
        } catch (FibInputException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong, Please try again.");
        }
        String filename;
        try {
            filename = FibHelper.writeSequence(fibSequence);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.ok(filename);
    }

}
