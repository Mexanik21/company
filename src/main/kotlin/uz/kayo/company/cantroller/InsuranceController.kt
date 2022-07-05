package uz.kayo.company.cantroller

import org.springframework.web.bind.annotation.*
import uz.kayo.company.dtos.InsuranceCreateDto
import uz.kayo.company.dtos.InsuranceUpdateDto
import uz.kayo.company.service.InsuranceService


@RestController
@RequestMapping("company/employee/insurance")
class InsuranceController(
    private val insuranceService: InsuranceService
) {

    @PostMapping("create")
    fun create(@RequestBody dto: InsuranceCreateDto) = insuranceService.create(dto)

    @GetMapping
    fun getAll() = insuranceService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id:Long) = insuranceService.getOne(id)

    @PutMapping("update/{id}")
    fun update(@PathVariable id:Long, @RequestBody dto: InsuranceUpdateDto) = insuranceService.update(id,dto)

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: Long) = insuranceService.delete(id)

}