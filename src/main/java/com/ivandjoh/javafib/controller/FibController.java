package com.ivandjoh.javafib.controller;

import com.ivandjoh.javafib.exception.FibOutOfRangeException;
import com.ivandjoh.javafib.utils.FibHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci")
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
    public ResponseEntity<String> findFibNumber(@RequestParam int x) {

        int fibNumber;
        try {
            fibNumber = FibHelper.execFib(x);
        } catch (FibOutOfRangeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.ok(String.valueOf(fibNumber));
    }
}
