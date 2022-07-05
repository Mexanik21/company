package uz.kayo.company.entities

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToOne


@Entity
class Insurance(
    var schemaName:String,
    var amount:Long,
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    var employer: Employer
):BaseEntity()