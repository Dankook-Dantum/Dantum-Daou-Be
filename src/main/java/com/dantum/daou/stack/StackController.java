package com.dantum.daou.stack;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("stacks")
public class StackController {
    private final StackService stackService;

    @GetMapping("/{userIdx}")
    public ResponseEntity<Object> getStacks(@PathVariable("userIdx") Long userIdx) {
        return stackService.getStack(userIdx);
    }

    @PostMapping("/{userIdx}")
    public ResponseEntity<Object> createStack(@PathVariable("userIdx") Long userIdx, @RequestBody StackDto stackDto) {
        return stackService.createStack(userIdx, stackDto);
    }

/*    @PatchMapping("/{userIdx}")
    public ResponseEntity<Object> updateStack(@PathVariable("userIdx") Long userIdx, @RequestBody StackDto stackDto) {
        return stackService.updateStack(userIdx, stackDto);
    }*/

}
