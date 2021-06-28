package com.airport.gatemanagement.web;


import com.airport.gatemanagement.dto.GateDto;
import com.airport.gatemanagement.dto.OccupyRequestDto;
import com.airport.gatemanagement.dto.UpdateWorkingTimeRequestDto;
import com.airport.gatemanagement.service.GateManagementService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/v1/gate/management")
public class GateManagementController {
    private final GateManagementService gateManagementService;


    public GateManagementController(final GateManagementService gateManagementService) {
        this.gateManagementService = gateManagementService;
    }

// 409 u slucaju da nema dostupan gate
    @PostMapping("/occupy")
    public GateDto occupyGate(@RequestBody final OccupyRequestDto occupyRequestDto) {
        return gateManagementService.occupyGate(occupyRequestDto);
    }

// 404 not found
    @PutMapping("/free/{gateNumber}")
    public GateDto freeGate(@PathVariable final String gateNumber) {
        return gateManagementService.freeGate(gateNumber);
    }


    @PutMapping("/working-time/update/{gateNumber}")
    public GateDto updateWorkingTime(@PathVariable final String gateNumber, @RequestBody final UpdateWorkingTimeRequestDto request) {
        return gateManagementService.updateWorkingTime(gateNumber, request);
    }


    @PutMapping("/working-time/remove/{gateNumber}")
    public GateDto removeWorkingTime(@PathVariable final String gateNumber) {
        return gateManagementService.removeWorkingTime(gateNumber);
    }

}
