package uz.kayo.company.dtos

import uz.kayo.company.entities.Company
import uz.kayo.company.entities.Employer
import uz.kayo.company.entities.Project

data class CompanyCreateDto(
    var name:String,
    var location:String,
    var employer: List<Employer>? = null
){
}



data class CompanyUpdateDto(
        var name:String,
        var location:String
)


data class CompanyResponseDto(
    var name:String,
    var location:String
){
    companion object{
        fun toDto(c: Company) = c.run {
            location?.let { CompanyResponseDto(name, it) }
        }
    }
}
