package com.ivan.sks.bs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/random")
public class RandomServiceController {

    @GetMapping("/number")
    public int number() {
        final int randomInt = new Random().nextInt(1000);
        log.info("Returning random number: {}", randomInt);
        return randomInt;
    }

    @GetMapping("/string")
    public String string(final HttpServletRequest request) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder();
        IntStream.range(0, 10)
                .map(i -> random.nextInt(89) + 33)
                .mapToObj(i -> (char) (i))
                .forEach(sb::append);

        return sb.toString() + " - " + request.getLocalAddr() + " - " + request.getRemoteAddr();
    }

}
