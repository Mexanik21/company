package uz.kayo.company.cantroller

import org.springframework.web.bind.annotation.*
import uz.kayo.company.dtos.EmployerCreateDto
import uz.kayo.company.dtos.EmployerUpdateDto
import uz.kayo.company.service.EmployerService

@RestController
@RequestMapping("company/employer")
class EmployerController(
        private val employerService: EmployerService
) {

    @PostMapping("create")
    fun create(@RequestBody dto:EmployerCreateDto) = employerService.create(dto)

    @GetMapping
    fun getAll() = employerService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id:Long) = employerService.getOne(id)

    @PutMapping("update/{id}")
    fun update(@PathVariable id:Long, @RequestBody dto: EmployerUpdateDto) = employerService.update(id,dto)

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: Long) = employerService.delete(id)
}