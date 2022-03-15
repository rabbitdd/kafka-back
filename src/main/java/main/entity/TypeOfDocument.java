package main.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "TypeOfDocument")
public class TypeOfDocument {
    @Id
    @Column(name = "type_of_document_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "privileges_id")
    private Long privilegesId;

    @Column(name = "instance_id")
    private Long instanceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TypeOfDocument that = (TypeOfDocument) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
