package uz.kayo.company.entities

import javax.persistence.*
import javax.persistence.CascadeType.*

@Entity
class Company(
    var name: String,
    var location:String? = null,
    @OneToMany(mappedBy = "company", cascade = [ALL])
    var employer: List<Employer>? = null,
    @OneToMany(mappedBy = "company", cascade = [ALL])
    var project: List<Project>? = null

): BaseEntity(){

}