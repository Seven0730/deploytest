package com.example.demofib;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fibonacci")
public class FibController {

    @PostMapping("")
    public Fib getFib(@RequestBody Fib fib) {
        List<BigInteger> fibonacci = calculate(fib.getElements() - 1);
        List<BigInteger> sorted = sortFib(fibonacci);
        return new Fib(fibonacci, sorted);
    }

    private List<BigInteger> calculate(int n) {
        List<BigInteger> fibonacci = new ArrayList<>();
        BigInteger[] dp = new BigInteger[n + 2];

        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        for (int i = 0; i <= n; i++) {
            fibonacci.add(dp[i]);
        }
        return fibonacci;
    }

    private List<BigInteger> sortFib(List<BigInteger> fib) {
        List<BigInteger> result = new ArrayList<>();
        int flag = 0;
        for (BigInteger num : fib) {
            if (num.testBit(0)) {
                result.add(flag, num);
            } else {
                result.add(0, num);
                flag++;
            }
        }
        return result;
    }
}
