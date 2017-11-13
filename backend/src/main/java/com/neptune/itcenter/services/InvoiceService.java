package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Invoice;
import com.neptune.itcenter.entities.InvoiceEntity;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class InvoiceService extends GenericService<InvoiceEntity, Invoice> {
    public InvoiceService() {
        super(InvoiceEntity.class, Invoice.class);
    }

    public List<InvoiceEntity> findAll() {
        TypedQuery<InvoiceEntity> query = getEntityManager().createNamedQuery(InvoiceEntity.FIND_ALL, InvoiceEntity.class);
        return query.getResultList();
    }

    public InvoiceEntity update(Invoice bom) {
        InvoiceEntity entity = findById(bom.getId());
        return super.update(entity);
    }

    @Override
    public InvoiceEntity toEntity(Invoice bom) {
        if (bom == null)
            return null;
        InvoiceEntity entity = super.toEntity(bom);
        return entity;
    }

    @Override
    public Invoice toBom(InvoiceEntity entity) {
        if (entity == null)
            return null;
        Invoice bom = super.toBom(entity);
        return bom;
    }
}
