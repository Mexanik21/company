package uz.kayo.company.service.impl

import org.springframework.stereotype.Service
import uz.kayo.company.dtos.InsuranceCreateDto
import uz.kayo.company.dtos.InsuranceResponseDto
import uz.kayo.company.dtos.InsuranceUpdateDto
import uz.kayo.company.entities.Insurance
import uz.kayo.company.repositories.EmployerRepository
import uz.kayo.company.repositories.InsuranceRepository
import uz.kayo.company.service.InsuranceService

@Service
class InsuranceServiceImpl(
    val insuranceRepository: InsuranceRepository,
    val employerRepository: EmployerRepository,
) : InsuranceService {
    override fun create(dto: InsuranceCreateDto) {
        val employer = employerRepository.findByName(dto.employerName)
        insuranceRepository.save(Insurance(dto.schemeName, dto.amount, employer))
    }

    override fun getAll(): List<InsuranceResponseDto> =
        insuranceRepository.findAll().map { InsuranceResponseDto.toDto(it) }

    override fun getOne(id: Long): InsuranceResponseDto {
        val insurance = insuranceRepository.findById(id).orElseThrow { Exception("") }
        return InsuranceResponseDto.toDto(insurance)
    }

    override fun update(id: Long, dto: InsuranceUpdateDto) {

    }

    override fun delete(id: Long) {
        insuranceRepository.deleteById(id)
    }

}