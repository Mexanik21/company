package uz.kayo.company.repositories

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import uz.kayo.company.entities.Employer

interface EmployerRepository:BaseRepository<Employer> {


    @Query("SELECT e FROM Employer e WHERE e.name IN (:names)")
    fun findByNames(@Param("names") names: List<String>?): List<Employer>

    fun findByNameIn(name: List<String>?):List<Employer>

    fun findByName(name: String):Employer

}