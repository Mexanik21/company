package uz.kayo.company.service.impl

import org.springframework.stereotype.Service
import uz.kayo.company.dtos.*
import uz.kayo.company.entities.Company
import uz.kayo.company.entities.Employer
import uz.kayo.company.repositories.CompanyRepository
import uz.kayo.company.repositories.EmployerRepository
import uz.kayo.company.service.EmployerService

@Service
class EmployerServiceImpl(
    val employerRepository: EmployerRepository,
    val companyRepository: CompanyRepository,
    val companyServiceImpl: CompanyServiceImpl

):EmployerService {
    override fun create(dto: EmployerCreateDto) {
        employerRepository.save(Employer(dto.name,
            dto.age,
            dto.designation,
            dto.job,
            dto.employeeRole,
            companyRepository.findByName(dto.companyName)
        ))
    }

    override fun getAll() = employerRepository.findAll().map { EmployerResponseDto.toDto(it) }

    override fun getOne(id: Long): EmployerResponseDto {
        val employer = employerRepository.findById(id).orElseThrow{Exception("")}
        return EmployerResponseDto.toDto(employer)
    }

    override fun update(id: Long, dto: EmployerUpdateDto) {
        var employer = employerRepository.findById(id).orElseThrow{Exception("")}
        val company = companyRepository.findByName(dto.companyName)
        dto.apply {
            dto.let {
                employer.name = dto.name
                employer.age = dto.age
                employer.job = dto.job
                employer.designation = dto.designation
//                employer.company = Company(companyName,company.location)
            }
        }
        employerRepository.save(employer)
    }


    override fun delete(id: Long) {
        employerRepository.deleteById(id)
    }
}