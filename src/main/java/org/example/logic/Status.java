package org.example.logic;

import java.util.Objects;

public class Status{
    public final String statusName;
    public final String inReport;
    public Checkable checkable;

    public Status(String statusName, String inReport,Checkable check) {
        this.statusName = statusName;
        this.inReport = inReport;
        this.checkable =check;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return statusName.equals(status.statusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusName);
    }
}
