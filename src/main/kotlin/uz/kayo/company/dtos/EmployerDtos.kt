package uz.kayo.company.dtos

import uz.kayo.company.entities.Company
import uz.kayo.company.entities.Employer
import uz.kayo.company.enums.EmployeeRoles

data class EmployerCreateDto(
    var name:String,
    var age:Int,
    var designation:String,
    var job:String,
    var companyName:String,
    var employeeRole:EmployeeRoles
)

data class EmployerUpdateDto(
    var name:String,
    var age:Int,
    var designation:String,
    var job:String,
    var employeeRole:EmployeeRoles,
    var companyName: String
)

data class EmployerResponseDto(
    var name:String,
    var age:Int,
    var designation:String,
    var job:String,
    var companyName: String
){
    companion object{
        fun toDto(e:Employer) = e.run {
            EmployerResponseDto(name, age, designation, job, company.name)
        }
    }
}