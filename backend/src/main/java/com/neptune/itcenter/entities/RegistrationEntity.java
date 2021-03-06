package com.neptune.itcenter.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "registrations")
@NamedQueries({
        @NamedQuery(name = RegistrationEntity.FIND_ALL, query = "SELECT r FROM RegistrationEntity r"),
        @NamedQuery(name = RegistrationEntity.FIND_ALL_BY_STUDENT_ID, query = "SELECT r FROM RegistrationEntity r WHERE r.invoice.student.id = :studentId"),
        @NamedQuery(name = RegistrationEntity.FIND_ALL_BY_INVOICE_ID, query = "SELECT r FROM RegistrationEntity r WHERE r.invoice.id = :invoiceId"),
        @NamedQuery(name = RegistrationEntity.FIND_ALL_BY_CLASS_ID, query = "SELECT r FROM RegistrationEntity r where r.attendedClass.id = :classId"),
        @NamedQuery(name = RegistrationEntity.FIND_CONFIRMED_BY_CLASS_ID, query = "SELECT r FROM RegistrationEntity r where r.attendedClass.id = :classId and r.invoice.confirmed = true"),
})
public class RegistrationEntity extends GenericEntity implements Serializable {

    public static final String FIND_ALL = "RegistrationEntity.findAll";
    public static final String FIND_ALL_BY_STUDENT_ID = "RegistrationEntity.findAllByStudentId";
    public static final String FIND_ALL_BY_INVOICE_ID = "RegistrationEntity.findAllByInvoiceId";
    public static final String FIND_ALL_BY_CLASS_ID = "RegistrationEntity.findAllByClassId";
    public static final String FIND_CONFIRMED_BY_CLASS_ID = "RegistrationEntity.findConfirmedByClassId";

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassEntity attendedClass;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    @Column
    private int grade;

    @Column
    private int absent;

    @Column
    private int late;

    public ClassEntity getAttendedClass() {
        return attendedClass;
    }

    public void setAttendedClass(ClassEntity attendedClass) {
        this.attendedClass = attendedClass;
    }

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }
}
