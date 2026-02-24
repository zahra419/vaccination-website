package com.example.demo.model;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "database_storage_status")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    
    private Long id;

     @Column(name = "snapshot_date")
    private Date snapshotDate;

    @Column(name = "total_size_gb")
    private Double totalSizeGb;

    @Column(name = "used_space_gb")
    private Double usedSpaceGb;

    public Storage() {
    }

    public Storage(Date snapshotDate, Double totalSizeGb, Double  usedSpaceGb) {
        this.snapshotDate = snapshotDate;
        this.totalSizeGb = totalSizeGb;
        this.usedSpaceGb = usedSpaceGb;
    }
    public Long getId() {
        return id;
    }           
    public Date getSnapshotDate() {
        return snapshotDate;
    }
    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }
    public Double getTotalSizeGb() {
        return  totalSizeGb;
    }

    public void setTotalSizeGb(Double totalSizeGb) {
        this.totalSizeGb = totalSizeGb;
    }
    public Double getUsedSpaceGb() {
        return usedSpaceGb;
    }
    public void setUsedSpaceGb(Double usedSpaceGb) {
        this.usedSpaceGb = usedSpaceGb;
    }
}
