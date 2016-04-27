package no.fk.event;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event")
public class Event<T> {
    private String id;
    private String verb;
    @XmlElement(nillable = true)
    private Type type;
    @XmlElement(nillable = true)
    private Date time;
    private String orgId;
    private List<T> data;

    public Event() {
        this.id = UUID.randomUUID().toString();
        this.time = new Date();
    }

    public Event(String orgId, String verb, Type type) {
        this.orgId = orgId;
        this.id = UUID.randomUUID().toString();
        this.verb = verb;
        this.type = type;
        this.time = new Date();
        this.data = new ArrayList<>();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void addData(T data) {
        this.data.add(data);
    }
}
