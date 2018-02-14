/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.sauzny.finagle.thrift.blacksmith;

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

public class QueryParams implements TBase<QueryParams, QueryParams._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("QueryParams");

  private static final TField COMMON_PARAMS_FIELD_DESC = new TField("commonParams", TType.STRUCT, (short)1);


  public com.sauzny.finagle.thrift.common.CommonParams commonParams;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    COMMON_PARAMS((short)1, "commonParams");
  
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
        case 1: // COMMON_PARAMS
          return COMMON_PARAMS;
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
    tmpMap.put(_Fields.COMMON_PARAMS, new FieldMetaData("commonParams", TFieldRequirementType.DEFAULT,
      new StructMetaData(TType.STRUCT, com.sauzny.finagle.thrift.common.CommonParams.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(QueryParams.class, metaDataMap);
  }


  public QueryParams() {
  }

  public QueryParams(
    com.sauzny.finagle.thrift.common.CommonParams commonParams)
  {
    this();
    this.commonParams = commonParams;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QueryParams(QueryParams other) {
    if (other.isSetCommonParams()) {
      this.commonParams = new com.sauzny.finagle.thrift.common.CommonParams(other.commonParams);
    }
  }

  public QueryParams deepCopy() {
    return new QueryParams(this);
  }

  @java.lang.Override
  public void clear() {
    this.commonParams = null;
  }

  public com.sauzny.finagle.thrift.common.CommonParams getCommonParams() {
    return this.commonParams;
  }

  public QueryParams setCommonParams(com.sauzny.finagle.thrift.common.CommonParams commonParams) {
    this.commonParams = commonParams;
    
    return this;
  }

  public void unsetCommonParams() {
    this.commonParams = null;
  }

  /** Returns true if field commonParams is set (has been asigned a value) and false otherwise */
  public boolean isSetCommonParams() {
    return this.commonParams != null;
  }

  public void setCommonParamsIsSet(boolean value) {
    if (!value) {
      this.commonParams = null;
    }
  }

  @SuppressWarnings("unchecked")
  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COMMON_PARAMS:
      if (value == null) {
        unsetCommonParams();
      } else {
        setCommonParams((com.sauzny.finagle.thrift.common.CommonParams)value);
      }
      break;
    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COMMON_PARAMS:
      return getCommonParams();
    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COMMON_PARAMS:
      return isSetCommonParams();
    }
    throw new IllegalStateException();
  }

  @java.lang.Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QueryParams)
      return this.equals((QueryParams)that);
    return false;
  }

  public boolean equals(QueryParams that) {
    if (that == null)
      return false;
    boolean this_present_commonParams = true && this.isSetCommonParams();
    boolean that_present_commonParams = true && that.isSetCommonParams();
    if (this_present_commonParams || that_present_commonParams) {
      if (!(this_present_commonParams && that_present_commonParams))
        return false;
      if (!this.commonParams.equals(that.commonParams))
        return false;
    }

    return true;
  }

  @java.lang.Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    boolean present_commonParams = true && (isSetCommonParams());
    builder.append(present_commonParams);
    if (present_commonParams)
      builder.append(commonParams);
    return builder.toHashCode();
  }

  public int compareTo(QueryParams other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    QueryParams typedOther = (QueryParams)other;

    lastComparison = Boolean.valueOf(isSetCommonParams()).compareTo(typedOther.isSetCommonParams());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommonParams()) {
      lastComparison = TBaseHelper.compareTo(this.commonParams, typedOther.commonParams);
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
        case 1: // COMMON_PARAMS
          if (field.type == TType.STRUCT) {
            this.commonParams = new com.sauzny.finagle.thrift.common.CommonParams();
            this.commonParams.read(iprot);
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
    if (this.commonParams != null) {
      oprot.writeFieldBegin(COMMON_PARAMS_FIELD_DESC);
      this.commonParams.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @java.lang.Override
  public String toString() {
    StringBuilder sb = new StringBuilder("QueryParams(");
    boolean first = true;
    sb.append("commonParams:");
    if (this.commonParams == null) {
      sb.append("null");
    } else {
      sb.append(this.commonParams);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }
}

