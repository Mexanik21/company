package uz.kayo.company.dtos

import uz.kayo.company.entities.Employer
import uz.kayo.company.entities.Insurance

data class InsuranceCreateDto(
    var schemeName:String,
    var amount:Long,
    var employerName: String
)
data class InsuranceUpdateDto(
    var schemeName:String,
    var amount:Long,

)


data class InsuranceResponseDto(
    var schemeName:String,
    var amount:Long,
    var employer: Employer,
){
    companion object{
        fun toDto(i:Insurance) = i.run {
            InsuranceResponseDto(schemaName,amount,employer)
        }
    }
}
