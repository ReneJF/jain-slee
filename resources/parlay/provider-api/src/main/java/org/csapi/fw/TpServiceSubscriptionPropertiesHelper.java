package org.csapi.fw;

/**
 *	Generated from IDL definition of alias "TpServiceSubscriptionProperties"
 *	@author JacORB IDL compiler 
 */

public final class TpServiceSubscriptionPropertiesHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, org.csapi.fw.TpServiceProperty[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static org.csapi.fw.TpServiceProperty[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(org.csapi.fw.TpServiceSubscriptionPropertiesHelper.id(), "TpServiceSubscriptionProperties",org.csapi.fw.TpServicePropertyListHelper.type());
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:org/csapi/fw/TpServiceSubscriptionProperties:1.0";
	}
	public static org.csapi.fw.TpServiceProperty[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		org.csapi.fw.TpServiceProperty[] _result;
		_result = org.csapi.fw.TpServicePropertyListHelper.read(_in);
		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, org.csapi.fw.TpServiceProperty[] _s)
	{
		org.csapi.fw.TpServicePropertyListHelper.write(_out,_s);
	}
}
