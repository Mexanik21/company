package uz.kayo.company.service.impl

import org.springframework.stereotype.Service
import uz.kayo.company.dtos.ProjectCreateDto
import uz.kayo.company.dtos.ProjectRemoveEmployerDto
import uz.kayo.company.dtos.ProjectResponseDto
import uz.kayo.company.dtos.ProjectUpdateDto
import uz.kayo.company.entities.Company
import uz.kayo.company.entities.Project
import uz.kayo.company.repositories.CompanyRepository
import uz.kayo.company.repositories.EmployerRepository
import uz.kayo.company.repositories.ProjectRepository
import uz.kayo.company.service.ProjectService
import kotlin.collections.ArrayList


@Service
class ProjectServiceImpl(
    private val projectRepository: ProjectRepository,
    private val companyRepository: CompanyRepository,
    private val employerRepository: EmployerRepository
):ProjectService {
    override fun create(dto: ProjectCreateDto) {
        var company:Company
        val employers =  employerRepository.findByNameIn(dto.employerNames)
        if (companyRepository.existsByName(dto.companyName)){
            company = companyRepository.findByName(dto.companyName)
            projectRepository.save(Project(dto.name,dto.cost,company, employers))
        } else{
            projectRepository.save(Project(dto.name,dto.cost,companyRepository.save(Company(dto.companyName)),employers))
        }
    }

    override fun getAll() = projectRepository.findAll().map{ ProjectResponseDto.toDto(it)}


    override fun getOne(id: Long) = ProjectResponseDto.toDto(projectRepository.findById(id).orElseThrow{Exception("")})

    override fun update(id: Long, dto: ProjectUpdateDto) {
        var project = projectRepository.findById(id).orElseThrow{Exception("")}
        dto.apply {
            project.let { project = it }
        }
    }
    override fun delete(id: Long) {
        projectRepository.deleteById(id)
    }
    override fun removeEmployerFromProject(employerId: Long, dto: ProjectRemoveEmployerDto) {
        val project = projectRepository.findByName(dto.employerName)
        val list = ArrayList(project.employer!!)
        list.remove(employerRepository.findById(project.id!!).get())
        update(project.id!!,ProjectUpdateDto(project.name,project.cost,list.toList()))
    }

}