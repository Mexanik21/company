package uz.kayo.company.cantroller

import org.springframework.web.bind.annotation.*
import uz.kayo.company.dtos.ProjectCreateDto
import uz.kayo.company.dtos.ProjectRemoveEmployerDto
import uz.kayo.company.dtos.ProjectUpdateDto
import uz.kayo.company.service.ProjectService
import uz.kayo.company.service.impl.ProjectServiceImpl

@RestController
@RequestMapping("company/project")
class ProjectController(
    private val projectService: ProjectService
) {

    @PostMapping("create")
    fun create(@RequestBody dto: ProjectCreateDto) = projectService.create(dto)

    @GetMapping
    fun getAll() = projectService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id:Long) = projectService.getOne(id)

    @PutMapping("update/{id}")
    fun update(@PathVariable id:Long, @RequestBody dto: ProjectUpdateDto) = projectService.update(id,dto)

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: Long) = projectService.delete(id)

    @PutMapping("update/employee/{id}")
    fun remove(@PathVariable id: Long, @RequestBody dto: ProjectRemoveEmployerDto) = projectService.removeEmployerFromProject(id,dto)

}