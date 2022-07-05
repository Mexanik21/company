package uz.kayo.company.dtos

import uz.kayo.company.entities.Employer
import uz.kayo.company.entities.Project

data class ProjectCreateDto(
    var name:String,
    var cost:Long,
    var companyName:String,
    var employerNames:List<String>? = null
)
data class ProjectUpdateDto(
    var name:String,
    var cost:Long,
    var employers: List<Employer>? = null
)

data class ProjectResponseDto(
    var name:String,
    var cost:Long,
){
    companion object{
        fun toDto(p: Project) = p.run {
            ProjectResponseDto(name,cost)
        }
    }
}

data class ProjectRemoveEmployerDto(
    var employerName: String
)