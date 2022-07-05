package uz.kayo.company.entities

import javax.persistence.*

@Entity
class Project(
    var name:String,
    var cost:Long,
    @ManyToOne
    var company: Company? = null,
    @ManyToMany(cascade = [CascadeType.PERSIST,CascadeType.MERGE])
    var employer: List<Employer>? = null,
):BaseEntity()