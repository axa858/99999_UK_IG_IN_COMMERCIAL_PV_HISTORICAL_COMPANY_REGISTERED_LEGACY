package com.ignite.transformation;

import java.io.Serializable;

public class ColumnMapping implements Serializable {
    private String source;
    private String type;
    private String target;
    private Integer position;
    private Integer length;

    /**
     * getter for source
     *
     * @return returns source
     */

    public String getSource() {
        return source;
    }

    /**
     * setter for source
     *
     * @param source source name
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * getter for type
     *
     * @return returns type
     */
    public String getType() {
        return type;
    }

    /**
     * setter for type
     *
     * @param type type of field
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * getter for position
     *
     * @return returns position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * setter for position
     *
     * @param position position of field
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * getter for length
     *
     * @return returns length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * setter for length
     *
     * @param length length of the field
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * getter for target
     *
     * @return -returns target
     */
    public String getTarget() {
        return target;
    }

    /**
     * setter for target
     *
     * @param target - target field
     */
    public void setTarget(String target) {
        this.target = target;
    }
}

