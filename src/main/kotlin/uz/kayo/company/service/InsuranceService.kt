package uz.kayo.company.service

import uz.kayo.company.dtos.InsuranceCreateDto
import uz.kayo.company.dtos.InsuranceResponseDto
import uz.kayo.company.dtos.InsuranceUpdateDto
import uz.kayo.company.entities.Employer

interface InsuranceService {
    fun create(dto: InsuranceCreateDto)
    fun getAll(): List<InsuranceResponseDto>
    fun getOne(id: Long): InsuranceResponseDto
    fun update(id: Long, dto: InsuranceUpdateDto)
    fun delete(id: Long)
}