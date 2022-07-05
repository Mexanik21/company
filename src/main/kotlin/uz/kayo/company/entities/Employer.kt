package uz.kayo.company.entities

import uz.kayo.company.enums.EmployeeRoles
import javax.persistence.*

@Entity
class Employer(
    var name:String,
    var age:Int,
    var designation:String,
    var job:String,
    @Enumerated(value = EnumType.STRING)
    val roles: EmployeeRoles,
    @ManyToOne
    var company: Company

):BaseEntity() {

}
