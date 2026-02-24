package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;


@Entity
@Table(name = "monitoring_status")
public class Monitoring {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status_date")
    private Date statusDate;
    @Column(name = "dg_role")
    private String dgRole;
    @Column(name = "db_status")
    private String dbStatus;
    @Column(name = "tablespace_name")
    private String tablespaceName;
    @Column(name = "tablespace_status")
    private String tablespaceStatus;
    @Column(name = "used_space_mb")
    private Long usedSpace;
    @Column(name = "free_space_mb")
    private Long freeSpace;
    @Column(name = "pct_used")
    private Long pctUsed;
    @Column (name = "notes")
    private String notes;

    public Monitoring() {
    }

    public Monitoring(Long id, Date statusDate, String dgRole, String dbStatus, String tablespaceName,
            String tablespaceStatus, Long usedSpace, Long freeSpace, Long pctUsed, String notes) {
        this.id = id;
        this.statusDate = statusDate;
        this.dgRole = dgRole;
        this.dbStatus = dbStatus;
        this.tablespaceName = tablespaceName;
        this.tablespaceStatus = tablespaceStatus;
        this.usedSpace = usedSpace;
        this.freeSpace = freeSpace;
        this.pctUsed = pctUsed;
        this.notes = notes;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getStatusDate() {
        return statusDate;
    }
    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
    public String getDgRole() {
        return dgRole;
    }
    public void setDgRole(String dgRole) {
        this.dgRole = dgRole;
    }
    public String getDbStatus() {
        return dbStatus;
    }
    public void setDbStatus(String dbStatus) {
        this.dbStatus = dbStatus;
    }
    public String getTablespaceName() {
        return tablespaceName;
    }
    public void setTablespaceName(String tablespaceName) {
        this.tablespaceName = tablespaceName;
    }

    public String getTablespaceStatus() {
        return tablespaceStatus;
    }
    public void setTablespaceStatus(String tablespaceStatus) {
        this.tablespaceStatus = tablespaceStatus;
    }
    public Long getUsedSpace() {
        return usedSpace;
    }
    public void setUsedSpace(Long usedSpace) {
        this.usedSpace = usedSpace;
    }
    public Long getFreeSpace() {
        return freeSpace;
    }
    public void setFreeSpace(Long freeSpace) {
        this.freeSpace = freeSpace;
    }
    public Long getPctUsed() {
        return pctUsed;
    }
    public void setPctUsed(Long pctUsed) {
        this.pctUsed = pctUsed;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


}