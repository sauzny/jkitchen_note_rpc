/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.sauzny.finagle.thrift.common;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

// No additional import required for struct/union.

public class FailDesc implements TBase<FailDesc, FailDesc._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("FailDesc");

  private static final TField NAME_FIELD_DESC = new TField("name", TType.STRING, (short)1);
  private static final TField FAIL_CODE_FIELD_DESC = new TField("failCode", TType.STRING, (short)2);
  private static final TField DESC_FIELD_DESC = new TField("desc", TType.STRING, (short)3);


  public String name;
  public String failCode;
  public String desc;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    NAME((short)1, "name"),
    FAIL_CODE((short)2, "failCode"),
    DESC((short)3, "desc");
  
    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();
  
    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }
  
    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME
          return NAME;
        case 2: // FAIL_CODE
          return FAIL_CODE;
        case 3: // DESC
          return DESC;
        default:
          return null;
      }
    }
  
    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }
  
    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }
  
    private final short _thriftId;
    private final String _fieldName;
  
    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }
  
    public short getThriftFieldId() {
      return _thriftId;
    }
  
    public String getFieldName() {
      return _fieldName;
    }
  }


  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new FieldMetaData("name", TFieldRequirementType.DEFAULT,
      new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.FAIL_CODE, new FieldMetaData("failCode", TFieldRequirementType.DEFAULT,
      new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.DESC, new FieldMetaData("desc", TFieldRequirementType.DEFAULT,
      new FieldValueMetaData(TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(FailDesc.class, metaDataMap);
  }


  public FailDesc() {
  }

  public FailDesc(
    String name,
    String failCode,
    String desc)
  {
    this();
    this.name = name;
    this.failCode = failCode;
    this.desc = desc;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FailDesc(FailDesc other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetFailCode()) {
      this.failCode = other.failCode;
    }
    if (other.isSetDesc()) {
      this.desc = other.desc;
    }
  }

  public FailDesc deepCopy() {
    return new FailDesc(this);
  }

  @java.lang.Override
  public void clear() {
    this.name = null;
    this.failCode = null;
    this.desc = null;
  }

  public String getName() {
    return this.name;
  }

  public FailDesc setName(String name) {
    this.name = name;
    
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been asigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getFailCode() {
    return this.failCode;
  }

  public FailDesc setFailCode(String failCode) {
    this.failCode = failCode;
    
    return this;
  }

  public void unsetFailCode() {
    this.failCode = null;
  }

  /** Returns true if field failCode is set (has been asigned a value) and false otherwise */
  public boolean isSetFailCode() {
    return this.failCode != null;
  }

  public void setFailCodeIsSet(boolean value) {
    if (!value) {
      this.failCode = null;
    }
  }

  public String getDesc() {
    return this.desc;
  }

  public FailDesc setDesc(String desc) {
    this.desc = desc;
    
    return this;
  }

  public void unsetDesc() {
    this.desc = null;
  }

  /** Returns true if field desc is set (has been asigned a value) and false otherwise */
  public boolean isSetDesc() {
    return this.desc != null;
  }

  public void setDescIsSet(boolean value) {
    if (!value) {
      this.desc = null;
    }
  }

  @SuppressWarnings("unchecked")
  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;
    case FAIL_CODE:
      if (value == null) {
        unsetFailCode();
      } else {
        setFailCode((String)value);
      }
      break;
    case DESC:
      if (value == null) {
        unsetDesc();
      } else {
        setDesc((String)value);
      }
      break;
    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();
    case FAIL_CODE:
      return getFailCode();
    case DESC:
      return getDesc();
    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case FAIL_CODE:
      return isSetFailCode();
    case DESC:
      return isSetDesc();
    }
    throw new IllegalStateException();
  }

  @java.lang.Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FailDesc)
      return this.equals((FailDesc)that);
    return false;
  }

  public boolean equals(FailDesc that) {
    if (that == null)
      return false;
    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }
    boolean this_present_failCode = true && this.isSetFailCode();
    boolean that_present_failCode = true && that.isSetFailCode();
    if (this_present_failCode || that_present_failCode) {
      if (!(this_present_failCode && that_present_failCode))
        return false;
      if (!this.failCode.equals(that.failCode))
        return false;
    }
    boolean this_present_desc = true && this.isSetDesc();
    boolean that_present_desc = true && that.isSetDesc();
    if (this_present_desc || that_present_desc) {
      if (!(this_present_desc && that_present_desc))
        return false;
      if (!this.desc.equals(that.desc))
        return false;
    }

    return true;
  }

  @java.lang.Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    boolean present_name = true && (isSetName());
    builder.append(present_name);
    if (present_name)
      builder.append(name);
    boolean present_failCode = true && (isSetFailCode());
    builder.append(present_failCode);
    if (present_failCode)
      builder.append(failCode);
    boolean present_desc = true && (isSetDesc());
    builder.append(present_desc);
    if (present_desc)
      builder.append(desc);
    return builder.toHashCode();
  }

  public int compareTo(FailDesc other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    FailDesc typedOther = (FailDesc)other;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(typedOther.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = TBaseHelper.compareTo(this.name, typedOther.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFailCode()).compareTo(typedOther.isSetFailCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFailCode()) {
      lastComparison = TBaseHelper.compareTo(this.failCode, typedOther.failCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDesc()).compareTo(typedOther.isSetDesc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDesc()) {
      lastComparison = TBaseHelper.compareTo(this.desc, typedOther.desc);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) {
        break;
      }
      switch (field.id) {
        case 1: // NAME
          if (field.type == TType.STRING) {
            this.name = iprot.readString();
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // FAIL_CODE
          if (field.type == TType.STRING) {
            this.failCode = iprot.readString();
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // DESC
          if (field.type == TType.STRING) {
            this.desc = iprot.readString();
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();
    
    oprot.writeStructBegin(STRUCT_DESC);
    if (this.name != null) {
      oprot.writeFieldBegin(NAME_FIELD_DESC);
      oprot.writeString(this.name);
      oprot.writeFieldEnd();
    }
    if (this.failCode != null) {
      oprot.writeFieldBegin(FAIL_CODE_FIELD_DESC);
      oprot.writeString(this.failCode);
      oprot.writeFieldEnd();
    }
    if (this.desc != null) {
      oprot.writeFieldBegin(DESC_FIELD_DESC);
      oprot.writeString(this.desc);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @java.lang.Override
  public String toString() {
    StringBuilder sb = new StringBuilder("FailDesc(");
    boolean first = true;
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("failCode:");
    if (this.failCode == null) {
      sb.append("null");
    } else {
      sb.append(this.failCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("desc:");
    if (this.desc == null) {
      sb.append("null");
    } else {
      sb.append(this.desc);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }
}

