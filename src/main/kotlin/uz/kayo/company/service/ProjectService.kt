package uz.kayo.company.service

import uz.kayo.company.dtos.ProjectCreateDto
import uz.kayo.company.dtos.ProjectRemoveEmployerDto
import uz.kayo.company.dtos.ProjectResponseDto
import uz.kayo.company.dtos.ProjectUpdateDto

interface ProjectService {
    fun create(dto:ProjectCreateDto)
    fun getAll():List<ProjectResponseDto>
    fun getOne(id:Long):ProjectResponseDto
    fun update(id: Long, dto: ProjectUpdateDto)
    fun delete(id: Long)
    fun removeEmployerFromProject(employerId: Long,dto: ProjectRemoveEmployerDto)
}