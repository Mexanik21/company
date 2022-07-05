package uz.kayo.company.service

import uz.kayo.company.dtos.CompanyCreateDto
import uz.kayo.company.dtos.CompanyResponseDto
import uz.kayo.company.dtos.CompanyUpdateDto

interface CompanyService {
    fun create(dto:CompanyCreateDto)
    fun getAll():List<CompanyResponseDto>
    fun getOne(id:Long):CompanyResponseDto
    fun update(id: Long, dto: CompanyUpdateDto)
    fun delete(id: Long)

}