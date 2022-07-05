package uz.kayo.company.service.impl

import org.springframework.stereotype.Service
import uz.kayo.company.dtos.CompanyCreateDto
import uz.kayo.company.dtos.CompanyResponseDto
import uz.kayo.company.dtos.CompanyUpdateDto
import uz.kayo.company.entities.Company
import uz.kayo.company.repositories.CompanyRepository
import uz.kayo.company.repositories.EmployerRepository
import uz.kayo.company.service.CompanyService


@Service
class CompanyServiceImpl(
    private val companyRepository: CompanyRepository,
    private val employerRepository: EmployerRepository,
    private val projectRepository: EmployerRepository
):CompanyService {
    override fun create(dto: CompanyCreateDto) {
        companyRepository.save(Company(dto.name,dto.location))
    }

    override fun getAll(): List<CompanyResponseDto> = companyRepository.findAll().map { CompanyResponseDto.toDto(it)!! }

    override fun getOne(id: Long): CompanyResponseDto = CompanyResponseDto.toDto(companyRepository.findById(id).orElseThrow{ Exception("")})!!

    override fun update(id: Long, dto: CompanyUpdateDto) {
        val company = companyRepository.findById(id).orElseThrow{Exception("")}
        dto.apply {
            name.let {
                company.name = it
            }
            location.let {
                company.location = it
            }
        }
        companyRepository.save(company)
    }


    override fun delete(id: Long) {
        companyRepository.deleteById(id)
    }

//    fun saveEmployee(name:String,dto:CompanyAddEmployerDto){
//        val company = companyRepository.findByName(name)
//
//        dto.run {
//
//            val list:ArrayList<Employer> = ArrayList(company.employer)
//            list.add(dto.employer)
//            company.employer = list.toList()
//        }
//
//    }

//    fun saveEmployee(employer1: Employer, name:String){
//        val company:Company = companyRepository.findByName(name)
//        companyRepository.save(Company(company.name,company.location, listOf(employer1)))
//    }
}