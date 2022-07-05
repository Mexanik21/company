package uz.kayo.company.service

import uz.kayo.company.dtos.EmployerCreateDto
import uz.kayo.company.dtos.EmployerResponseDto
import uz.kayo.company.dtos.EmployerUpdateDto
import uz.kayo.company.entities.Employer

interface EmployerService {
    fun create(dto: EmployerCreateDto)
    fun getAll(): List<EmployerResponseDto>
    fun getOne(id: Long): EmployerResponseDto
    fun update(id: Long, dto: EmployerUpdateDto)
    fun delete(id: Long)
}