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

public class QueryResult implements TBase<QueryResult, QueryResult._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("QueryResult");

  private static final TField COMMON_RESULT_FIELD_DESC = new TField("commonResult", TType.STRUCT, (short)1);


  public com.sauzny.finagle.thrift.common.CommonResult commonResult;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    COMMON_RESULT((short)1, "commonResult");
  
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
        case 1: // COMMON_RESULT
          return COMMON_RESULT;
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
    tmpMap.put(_Fields.COMMON_RESULT, new FieldMetaData("commonResult", TFieldRequirementType.DEFAULT,
      new StructMetaData(TType.STRUCT, com.sauzny.finagle.thrift.common.CommonResult.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(QueryResult.class, metaDataMap);
  }


  public QueryResult() {
  }

  public QueryResult(
    com.sauzny.finagle.thrift.common.CommonResult commonResult)
  {
    this();
    this.commonResult = commonResult;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QueryResult(QueryResult other) {
    if (other.isSetCommonResult()) {
      this.commonResult = new com.sauzny.finagle.thrift.common.CommonResult(other.commonResult);
    }
  }

  public QueryResult deepCopy() {
    return new QueryResult(this);
  }

  @java.lang.Override
  public void clear() {
    this.commonResult = null;
  }

  public com.sauzny.finagle.thrift.common.CommonResult getCommonResult() {
    return this.commonResult;
  }

  public QueryResult setCommonResult(com.sauzny.finagle.thrift.common.CommonResult commonResult) {
    this.commonResult = commonResult;
    
    return this;
  }

  public void unsetCommonResult() {
    this.commonResult = null;
  }

  /** Returns true if field commonResult is set (has been asigned a value) and false otherwise */
  public boolean isSetCommonResult() {
    return this.commonResult != null;
  }

  public void setCommonResultIsSet(boolean value) {
    if (!value) {
      this.commonResult = null;
    }
  }

  @SuppressWarnings("unchecked")
  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COMMON_RESULT:
      if (value == null) {
        unsetCommonResult();
      } else {
        setCommonResult((com.sauzny.finagle.thrift.common.CommonResult)value);
      }
      break;
    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COMMON_RESULT:
      return getCommonResult();
    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COMMON_RESULT:
      return isSetCommonResult();
    }
    throw new IllegalStateException();
  }

  @java.lang.Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QueryResult)
      return this.equals((QueryResult)that);
    return false;
  }

  public boolean equals(QueryResult that) {
    if (that == null)
      return false;
    boolean this_present_commonResult = true && this.isSetCommonResult();
    boolean that_present_commonResult = true && that.isSetCommonResult();
    if (this_present_commonResult || that_present_commonResult) {
      if (!(this_present_commonResult && that_present_commonResult))
        return false;
      if (!this.commonResult.equals(that.commonResult))
        return false;
    }

    return true;
  }

  @java.lang.Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    boolean present_commonResult = true && (isSetCommonResult());
    builder.append(present_commonResult);
    if (present_commonResult)
      builder.append(commonResult);
    return builder.toHashCode();
  }

  public int compareTo(QueryResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    QueryResult typedOther = (QueryResult)other;

    lastComparison = Boolean.valueOf(isSetCommonResult()).compareTo(typedOther.isSetCommonResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommonResult()) {
      lastComparison = TBaseHelper.compareTo(this.commonResult, typedOther.commonResult);
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
        case 1: // COMMON_RESULT
          if (field.type == TType.STRUCT) {
            this.commonResult = new com.sauzny.finagle.thrift.common.CommonResult();
            this.commonResult.read(iprot);
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
    if (this.commonResult != null) {
      oprot.writeFieldBegin(COMMON_RESULT_FIELD_DESC);
      this.commonResult.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @java.lang.Override
  public String toString() {
    StringBuilder sb = new StringBuilder("QueryResult(");
    boolean first = true;
    sb.append("commonResult:");
    if (this.commonResult == null) {
      sb.append("null");
    } else {
      sb.append(this.commonResult);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }
}

