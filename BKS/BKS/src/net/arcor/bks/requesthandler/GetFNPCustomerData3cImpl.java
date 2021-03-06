/*
    $Header:   //PVCS_BKS/archives/BKS/BKS/src/net/arcor/bks/requesthandler/GetFNPCustomerData3cImpl.java-arc   1.57   Sep 17 2018 14:37:58   makuier  $

    $Log:   //PVCS_BKS/archives/BKS/BKS/src/net/arcor/bks/requesthandler/GetFNPCustomerData3cImpl.java-arc  $
 * 
 *    Rev 1.57   Sep 17 2018 14:37:58   makuier
 * Support for Fibre services added
 * 
 *    Rev 1.56   May 04 2018 11:15:54   vikas.s
 * Added new customer group(80)
 * 
 *    Rev 1.55   Oct 27 2017 14:05:26   makuier
 * Added BIR to not supported bundle types.
 * 
 *    Rev 1.54   Jul 27 2017 12:48:24   makuier
 * Use service billing name fro volume cap
 * 
 *    Rev 1.53   Jun 08 2017 07:50:48   makuier
 * Return volume caps
 * 
 *    Rev 1.52   Jan 27 2017 09:33:28   gaurav.verma
 *  Increment the criteria for filtering the customer group for Project ID: 188429_256581
 * 
 *    Rev 1.51   Jan 19 2017 15:51:08   makuier
 * Skip Intro for SID services
 * 
 *    Rev 1.50   Oct 28 2016 18:42:32   makuier
 * - trigger generic ref data for HW
 * 
 *    Rev 1.49   Sep 23 2016 12:28:56   makuier
 * Populate default value of 0 if the tariff option does not have any duration characteristic (V0231)
 * 
 *    Rev 1.48   Sep 21 2016 07:24:46   makuier
 * Consider product code in the address key.
 * 
 *    Rev 1.47   Jul 07 2016 15:42:24   lejam
 * RMS-152753 PPM-196371 DSL Portfolio 2016 - replaced service code by "minimumDuration" in tvcenteropions 
 * 
 *    Rev 1.46   Jul 07 2016 13:10:08   gaurav.verma
 * Add the new node ContractualObligation
 * 
 *    Rev 1.45   Jun 30 2016 09:14:50   gaurav.verma
 * RMS-152753 PPM-196371 DSL Portfolio 2016 - Changes for TariffOptionList and TvCenterOptionList
 * 
 *    Rev 1.44   Dec 03 2015 21:33:16   sibani.panda
 * RMS 149627 PPM-183594 - Changed Error code and text in case of customer of a service provider
 * 
 *    Rev 1.43   Sep 15 2015 15:49:58   makuier
 * Support for rented hardware added.
 * 
 *    Rev 1.42   Jun 09 2015 16:52:06   sibani.panda
 * RMS-142618: added method populateCustomerPermissions for populating customer permissions details from new tables
 * 
 *    Rev 1.41   Apr 02 2014 09:28:32   makuier
 * Check the validation row.
 * 
 *    Rev 1.40   Mar 17 2014 10:02:22   makuier
 * Separate email validation.
 * 
 *    Rev 1.39   Mar 06 2014 09:22:42   makuier
 * Do not populate EmailValidationResult if any mandatory sub node is missing
 * 
 *    Rev 1.38   Jan 22 2014 12:02:38   makuier
 * Populate mandate node only  if both mandatory sub-nodes are populated.
 * 
 *    Rev 1.37   Oct 10 2013 12:31:38   makuier
 * Populate bank node only  if both mandatory sub-nodes are populated.
 * 
 *    Rev 1.36   Jun 12 2013 11:16:38   makuier
 * Changed the serializer
 * 
 *    Rev 1.35   Oct 12 2012 13:58:38   makuier
 * Added V0012 to the list of services.
 * 
 *    Rev 1.34   Aug 22 2012 16:08:54   makuier
 * - Do not populate hot subscription if the characteristic is not populated
 * 
 *    Rev 1.33   Jul 19 2012 16:57:08   makuier
 * Populate Contract end date
 * 
 *    Rev 1.32   Jun 22 2012 14:05:34   makuier
 * Populate log table
 * 
 *    Rev 1.31   May 04 2012 13:49:04   makuier
 * Do not raise BKS-00026 for DSL-R products
 * 
 *    Rev 1.30   Apr 19 2012 10:23:34   makuier
 * Allow conversion method for access numbers.
 * 
 *    Rev 1.29   Apr 13 2012 11:11:02   makuier
 * I1351 added to the list of TV add-ons
 * 
 *    Rev 1.28   Mar 29 2012 15:14:56   makuier
 * remove duplicates from customer list
 * 
 *    Rev 1.27   Mar 26 2012 12:25:00   makuier
 * Parsing phone number in contact medium supported.
 * 
 *    Rev 1.26   Mar 22 2012 10:26:04   makuier
 * Time to live added.
 * 
 *    Rev 1.25   Mar 08 2012 14:43:44   makuier
 * Validate formatted access number
 * 
 *    Rev 1.24   Mar 07 2012 11:51:30   makuier
 * handle upstream bandwidth
 * 
 *    Rev 1.23   Feb 22 2012 15:01:20   makuier
 * Adapted to new XSD.
 * 
 *    Rev 1.22   Feb 17 2012 14:56:52   makuier
 * Handle open termination of DE.
 * 
 *    Rev 1.21   Feb 03 2012 13:27:00   makuier
 * Handle when only DE is in open order
 * 
 *    Rev 1.20   Feb 01 2012 17:19:08   makuier
 * Do not add the failed COM open orders to order list.
 * 
 *    Rev 1.19   Jan 27 2012 12:36:34   makuier
 * Use AsIs node for termination open order.
 * 
 *    Rev 1.18   Jan 19 2012 14:58:52   wlazlow
 * SPN-BKS-000117657, The empty productOfferingToBe nodes are filtered out.
 * 
 *    Rev 1.17   Dec 01 2011 12:29:34   makuier
 * - Populate order item type based on customer intention.
 * 
 *    Rev 1.16   Nov 21 2011 13:49:44   makuier
 * Do not duplicate local area code.
 * 
 *    Rev 1.15   Nov 16 2011 14:40:14   makuier
 * Bug fix
 * 
 *    Rev 1.14   Nov 15 2011 11:44:34   makuier
 * Jump over unsupported bundles.
 * 
 *    Rev 1.13   Nov 04 2011 11:08:26   makuier
 * All hardware types returned when request type is not CPD or ICS
 * 
 *    Rev 1.12   Oct 21 2011 15:54:20   makuier
 * Call SBUS service to retrieve open orders.
 * 
 *    Rev 1.11   Oct 20 2011 13:33:04   makuier
 * Do not filter the last customer out in case of parsing error.
 * 
 *    Rev 1.10   Sep 01 2011 15:58:42   makuier
 * Initialize change end data for every bundle.
 * 
 *    Rev 1.9   Aug 26 2011 15:32:08   makuier
 * ITK 30916.  Seperate numeric and non-numeric part of street number
 * ITK 31028. poulate service billing name
 * 
 *    Rev 1.8   Jul 22 2011 15:42:24   makuier
 * Put TVcenter tarif options into customer facing service
 * 
 *    Rev 1.7   Jul 18 2011 17:49:22   makuier
 * Delivery type corrected. 
 * 
 *    Rev 1.6   Jul 05 2011 17:56:30   makuier
 * Handle the special services for open orders.
 * 
 *    Rev 1.5   Jun 22 2011 15:37:22   makuier
 * V0002 added to voice list
 * 
 *    Rev 1.4   Jun 14 2011 12:46:56   makuier
 * - relate reference data to the software version.
 * 
 *    Rev 1.3   Jun 03 2011 16:06:56   makuier
 * Refactored for malti threading
 * 
 *    Rev 1.2   May 25 2011 15:08:50   makuier
 * Ibatis maps date to timestamp.
 * 
 *    Rev 1.1   May 24 2011 12:55:20   makuier
 * Softened the validation.
 * 
 *    Rev 1.0   May 16 2011 17:37:40   makuier
 * Initial revision.
 * 
*/
package net.arcor.bks.requesthandler;

import java.io.StringWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.arcor.bks.client.DatabaseClient;
import net.arcor.bks.client.DatabaseClientConfig;
import net.arcor.bks.common.BksDataException;
import net.arcor.bks.common.BksHelper;
import net.arcor.bks.common.BksRefDataCacheHandler;
import net.arcor.bks.common.FNPInformationHolder;
import net.arcor.bks.db.GeneralDAO;
import net.arcor.bks.db.GetFNPCustomerDataDAO;
import net.arcor.bks.util.FudickarPhoneticConverter;
import net.arcor.mcf2.exception.base.MCFException;
import net.arcor.mcf2.model.ServiceObjectEndpoint;
import net.arcor.mcf2.model.ServiceResponse;
import net.arcor.mcf2.sender.MessageSender;
import net.arcor.mcf2.xml.ExperimentalXmlProcessor;
import net.arcor.mcf2.xml.XmlProcessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.UncategorizedSQLException;
import org.w3c.dom.Node;

import com.domainlanguage.time.CalendarDate;
import com.vodafone.mcf2.ws.exception.FunctionalException;
import com.vodafone.mcf2.ws.exception.FunctionalRuntimeException;
import com.vodafone.mcf2.ws.exception.TechnicalException;
import com.vodafone.mcf2.ws.model.impl.ServiceRequestSoap;
import com.vodafone.mcf2.ws.model.impl.ServiceResponseSoap;
import com.vodafone.mcf2.ws.service.SoapEndpoint;
import com.vodafone.mcf2.ws.service.SoapOperation;

import de.vodafone.esb.schema.common.commontypes_esb_001.ComplexPhoneNumber;
import de.vodafone.esb.schema.common.sidcom_fnporder_001.BackendOrder;
import de.vodafone.esb.schema.common.sidcom_fnporder_001.OrderItem;
import de.vodafone.esb.schema.common.sidcom_getcustomerinfo_001.CustomerInformation;
import de.vodafone.esb.schema.common.sidcom_getcustomerinfo_001.CustomerInformation.OpenOrder;
import de.vodafone.esb.schema.common.sidcom_getcustomerinfo_001.CustomerInformation.ProductOfferingSubscription;
import de.vodafone.esb.schema.common.sidcom_masterdata_001.BankAccount;
import de.vodafone.esb.schema.common.sidcom_masterdata_001.BillingAccount;
import de.vodafone.esb.schema.common.sidcom_masterdata_001.InvoiceDelivery;
import de.vodafone.esb.schema.common.sidcom_masterdata_001.Mandate;
import de.vodafone.esb.schema.common.sidcom_masterdata_001.MethodOfPayment;
import de.vodafone.esb.schema.common.sidcom_masterdata_001.SepaBankAccount;
import de.vodafone.esb.schema.common.sidcom_productdata_001.CharacteristicValue;
import de.vodafone.esb.schema.common.sidcom_productdata_001.DetachedHouse;
import de.vodafone.esb.schema.common.sidcom_productdata_001.GermanPropertyAddress;
import de.vodafone.esb.schema.common.sidcom_productdata_001.Product;
import de.vodafone.esb.schema.common.sidcom_productdata_001.ProductOfferingOccurrence;
import de.vodafone.esb.schema.common.sidcom_productdata_001.ProductOfferingOccurrence.ContractStartDate;
import de.vodafone.esb.schema.common.sidcom_productdata_001.ProductOfferingOccurrence.MinimumContractDuration;
import de.vodafone.esb.schema.common.sidcom_productdata_001.TerminationData;
import de.vodafone.esb.service.sbus.bks.bks_005.GetFNPCustomerDataRequest;
import de.vodafone.esb.service.sbus.bks.bks_005.GetFNPCustomerDataResponse;
import de.vodafone.esb.service.sbus.com.com_prov_001.GetOrderDetailsRequest;
import de.vodafone.esb.service.sbus.com.com_prov_001.GetOrderDetailsResponse;
import de.vodafone.esb.service.sbus.com.com_prov_001.OrderOutputFormat;
import de.vodafone.linkdb.epsm_bkstypes_001.CompanyDataQueryInput;
import de.vodafone.linkdb.epsm_bkstypes_001.PersonDataQueryInput;
import edu.emory.mathcs.backport.java.util.Arrays;

@SoapEndpoint(soapAction = "/BKS-005/GetFNPCustomerData", context = "de.vodafone.esb.service.sbus.bks.bks_005", schema = "classpath:schema/BKS-005.xsd")
public class GetFNPCustomerData3cImpl implements SoapOperation<GetFNPCustomerDataRequest, GetFNPCustomerDataResponse> {

    /** The logger. */
    private final static Log log = LogFactory.getLog(GetFNPCustomerData3cImpl.class);

    @Autowired
	private MessageSender messageSender;

	final static String[] voiceServices = {"V0010","V0003","V0004","V0002","V0001","V0011","V0012","VI002","VI003","VI006","VI009","VI201","VI018","VI019","V0100"};
	final static String[] accessServices = {"I1209","I1210","I1213","I121z","I1290","V0003","V0010","V0011","V0012"};
	final static String[] internetServices = {"I1209","I1210","I1213","I121z","I1290","I1040"};
	final static String[] voipServices = {"VI002","VI003","VI006","VI009","VI018","VI019"};
	final static String[] hardwareServices = {"I1223","I1291","I1293","I1294","I1295","I1350"
		,"I1359","V0048","V0107","V0108","V0109","V0110","V0114","V011A","V011C","V0328"
		,"V0330","V0850","VI050","VI051","VI052","VI053","VI054","VI055","VI057"};
	final static String[] notSupportedBundleTypes = {"IPCENTREX_MOBILE","IPCENTREX_SDSL","SDSL","SIPTRUNK","BIR"};
	final static String[] validStatus = {"NEW","IN_PROGRESS","FAILED","SUCCESS"};
	/**
	 * The operation "GetFNPCustomerData" of the service "GetFNPCustomerData".
	 */
	public ServiceResponseSoap<GetFNPCustomerDataResponse> invoke(ServiceObjectEndpoint<GetFNPCustomerDataRequest> serviceObject) 
			throws TechnicalException,FunctionalException,FunctionalRuntimeException {
		int tries =0;
		int maxTries = 10;
		BksHelper theHelper = new BksHelper();
		try {
			maxTries = Integer.parseInt(DatabaseClientConfig.getSetting("databaseclient.MaxRetries"));
		} catch (Exception e1) {
			// Ignore (Use Default)
		}
        while (!BksRefDataCacheHandler.isRefdataInitialized() && tries < maxTries){
        	tries++;
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
        }
        if (!BksRefDataCacheHandler.isRefdataInitialized()){
        	log.error("The application is not initialized after max. number of tries ( "+ tries +").");
        	log.error("Please increase the value of databaseclient.MaxRetries and restart the application.");
        	System.exit(0);
        }
		GetFNPCustomerDataDAO dao = (GetFNPCustomerDataDAO) DatabaseClient.getBksDataAccessObject(null, "GetFNPCustomerDataDAO");
		GetFNPCustomerDataRequest request = serviceObject.getPayload();
		GetFNPCustomerDataResponse output = new GetFNPCustomerDataResponse();
        long startTime = System.currentTimeMillis();
		try {
			output = getSIDCustomerData(dao,request, theHelper);
		} catch (BksDataException e) {
			log.error(e.getText());
	        long endTime = System.currentTimeMillis();
			populateLogTable(e.getCode(), e.getText(), null, serviceObject.getCorrelationID(), 
					"GetFNPCustomerData,005", null, startTime, endTime, false,request);
			throw new FunctionalException(e.getCode(),e.getText());
		} catch (Exception e) {
			log.error(e.getMessage());
	        long endTime = System.currentTimeMillis();
			populateLogTable("BKSCOM-ERROR-000008", "Precondition check error", null, serviceObject.getCorrelationID(), 
					"GetFNPCustomerData,005", null, startTime, endTime, false,request);
			throw new TechnicalException("BKSCOM-ERROR-000008","Precondition check error",e);
		} finally {
			try {
				dao.closeConnection();
			} catch (Exception e) {
			}
		}

		
		return new ServiceResponseSoap<GetFNPCustomerDataResponse>(output);
	}

	CustomerInformation getCustomerInfo(String customerNumber, String reqType) throws  Exception{
		BksHelper theHelper = new BksHelper();
		GetFNPCustomerDataDAO dao = (GetFNPCustomerDataDAO) DatabaseClient.getBksDataAccessObject(null, "GetFNPCustomerDataDAO");
		GetFNPCustomerDataRequest request = new GetFNPCustomerDataRequest();
		request.setCustomerNumber(customerNumber);
		request.setRequestType(reqType);
		GetFNPCustomerDataResponse output = new GetFNPCustomerDataResponse();
		try {
			output = getSIDCustomerData(dao,request, theHelper);
			ExperimentalXmlProcessor xmlProc = ExperimentalXmlProcessor.getInstance();
			xmlProc.serialize(output, "schema/BKS-004.xsd", "de.vodafone.esb.service.sbus.bks.bks_004");
		} finally {
			try {
				dao.closeConnection();
			} catch (Exception e) {
			}
		}
		
		return output.getSid().get(0);
	}

	private GetFNPCustomerDataResponse getSIDCustomerData(
			GetFNPCustomerDataDAO dao, GetFNPCustomerDataRequest request, 
			 BksHelper theHelper) throws Exception {
		GetFNPCustomerDataResponse resp = new GetFNPCustomerDataResponse();
		resp.setSidcomVersion("1.0");
	    String requestType = request.getRequestType();
		FNPInformationHolder infoHolder = new FNPInformationHolder();
		ArrayList<HashMap<String, Object>> custList = getCustomerList(dao, request,infoHolder,requestType, theHelper);
		int maxReturnedCustomer = 20;
		try {
			maxReturnedCustomer = Integer.parseInt(DatabaseClientConfig.getSetting("databaseclient.MaxReturnedCustomer"));
		} catch (Exception e)  {
			// ignore
		}
		int maxLoop = (maxReturnedCustomer<custList.size())?maxReturnedCustomer:custList.size();
		for (int j = 0; j < maxLoop; j++) {
			infoHolder.setVoice(false);
			String customerNumber = (String) custList.get(j).get("CUSTOMER_NUMBER");
			String encryptKey = (String) custList.get(j).get("ENCRYPTION_KEY");
			theHelper.setCustomerEncKey(encryptKey);
			resp.getSid().add(new CustomerInformation());
			if (!requestType.equals("GOL") && !requestType.equals("GAP") && !requestType.equals("RCO")) {
				populateCustomerData(custList.get(j), resp.getSid().get(j),infoHolder, theHelper);
				populateCustomerPermissions(dao,customerNumber,resp.getSid().get(j), theHelper);
				String addressId = (String) custList.get(j).get("PRIMARY_ADDRESS_ID");
				String refDataKey = "CUSTOMER;ADDRESS";
				populateAddress(dao, addressId, refDataKey, resp.getSid().get(j), theHelper);
				String accInfoId = (String) custList.get(j).get("PRIMARY_ACCESS_INFORMATION_ID");
				if (accInfoId != null)
					populateAccessInfo(dao, accInfoId,"CUSTOMER", resp.getSid().get(j), theHelper);
				try {
					populateBillingAccount(dao, custList.get(j), resp.getSid().get(j), theHelper);
				} catch (BksDataException e) {
					if (custList.size()==1){
						throw new BksDataException(e.getCode(),e.getText());
					}
					custList.remove(j);
					resp.getSid().remove(j);
					j--;
					maxLoop = (maxReturnedCustomer<custList.size())?maxReturnedCustomer:custList.size();
					continue;
				}	
			}
			if (!requestType.equals("GOL") && !requestType.equals("CID")) {
				ArrayList<HashMap<String, Object>> bundles = null;
				if (request.getBarcode() != null && 
					request.getAccessNumber() == null &&
					request.getCustomerNumber() == null)
					bundles = dao.getBundlesForBarcode(request.getBarcode());
				else if (request.getQueryLevel()== null || 
						request.getQueryLevel().equals("customer")|| 
						(request.getAccessNumber() == null &&
						request.getSerialNumber() == null)) {
					bundles = dao.getBundlesForCustomer(customerNumber);
					if (requestType.equals("RCO")) { 
						filterAoMasteredBundles(bundles);
						if (bundles.size() == 0)
							throw new BksDataException("Not Ao Mastered");
					}
				} else if (request.getAccessNumber() != null)
					bundles = dao.getBundlesForAccess(request.getAccessNumber());
				else if (request.getSerialNumber() != null)
					bundles = dao.getBundlesForBundleId(request.getSerialNumber());
				for (int i = 0;bundles!=null&& i < bundles.size(); i++) {
					theHelper.setDesiredNewElement(0);
					infoHolder.setChangeEndDate(true);
					String bundleId = (String)bundles.get(i).get("BUNDLE_ID");
					ArrayList<HashMap<String, Object>>bundleItems = dao.getBundleItems(bundleId);
					String bundleType = (String)bundles.get(i).get("BUNDLE_TYPE_RD");
					if (bundleItems==null||bundleItems.size()==0||Arrays.asList(notSupportedBundleTypes).contains(bundleType)){
						bundles.remove(i);
						i--;
						continue;
					}	
					populateSalesPackageInfo(dao,bundleId,resp.getSid().get(j));
					String aoFlagString = (String)bundles.get(i).get("AOSTATUS");
					boolean aoFlag = false;
					if (aoFlagString!=null)
						aoFlag = (aoFlagString.equals("Y"))?true:false;
					resp.getSid().get(j).getProductOfferingSubscription().get(i).setAoMastered(aoFlag);
					resp.getSid().get(j).getProductOfferingSubscription().get(i).setSerialNumber(bundleId);
					populateProductOffering(dao, requestType,bundleItems,resp.getSid().get(j),
							infoHolder,theHelper);
				}
			}
			if (!requestType.equals("CID") && !requestType.equals("GAP") && !requestType.equals("RCO"))
				handleOpenOrders(dao,customerNumber,resp.getSid().get(j),
						infoHolder,requestType,theHelper);
			resp.getSid().get(j).setCustomerNumber(customerNumber);
			if (custList.size()>1 && !doesCustomerParse(resp.getSid().get(j))){
				custList.remove(j);
				resp.getSid().remove(j);
				j--;
				maxLoop = (maxReturnedCustomer<custList.size())?maxReturnedCustomer:custList.size();
				continue;
			}
		}
		return resp;
	}
	
	private void populateCustomerPermissions(GetFNPCustomerDataDAO dao,
			String customerNumber, CustomerInformation customerInformation, BksHelper theHelper) throws Exception {
		HashMap<String,Object[]> colPathMap = 
				BksRefDataCacheHandler.getCcbSidMap().get("CUSTOMER;CUSTOMER");
		ArrayList<HashMap<String, Object>> perms = dao.getCustomerPermissionInfo(customerNumber);
        if (perms==null  || perms.size()==0)
                        return;
        HashMap<String,Boolean> indicatorData=new HashMap<String, Boolean>();
        indicatorData.put("CUSTOMER_DATA_INDICATOR",false);
        indicatorData.put("PERSONAL_DATA_INDICATOR",false);
        indicatorData.put("MARKETING_PHONE_INDICATOR",false);
        indicatorData.put("MARKETING_FAX_INDICATOR",false);
        for (int i=0;perms!=null&&i<perms.size();i++){
                        String  permId = (String) perms.get(i).get("PERMISSION_ID");
                        String  srvId = (String) perms.get(i).get("SERVICE_ID");
                        String  value = (String) perms.get(i).get("PERMISSION_VALUE");
                        Boolean boolVal = theHelper.convertToBoolean(value);
                        String indicatorName = BksHelper.getPermnamemap().get(permId+";"+srvId);
                        if (indicatorData.get(indicatorName)!=null)
                                        indicatorData.put(indicatorName, boolVal||indicatorData.get(indicatorName));
        }
        HashMap<String,Object> ccbData=new HashMap<String, Object>();
        for (String key : indicatorData.keySet())
                        ccbData.put(key,(indicatorData.get(key))?"Y":"N");
        populateSidNode(colPathMap, ccbData, customerInformation, theHelper);

	}

	private void filterAoMasteredBundles(
			ArrayList<HashMap<String, Object>> bundles) {
		for (int j = 0; j < bundles.size(); j++) {
			String aoMastered = (String)bundles.get(j).get("AOSTATUS");
			if (aoMastered == null || aoMastered.equals("N")){
				bundles.remove(j);
				j--;
				continue;
			}
		}
	}

	private void handleOpenOrders(GetFNPCustomerDataDAO dao,
			String customerNumber, CustomerInformation customerInformation, 
			FNPInformationHolder infoHolder, 
			String requestType, BksHelper theHelper)  throws Exception  {
		ArrayList<String> orderIds = handleComOpenOrders(dao,customerNumber,customerInformation,infoHolder,theHelper);
		ArrayList<HashMap<String, Object>> openOrders = dao.getOpenOrders(customerNumber);
		for (int i=0;openOrders != null && i<openOrders.size();i++) {
			if (orderIds.contains((String)openOrders.get(i).get("CUSTOMER_TRACKING_ID")))
				continue;
			populateOrderInfo(dao,openOrders.get(i),customerInformation,requestType,infoHolder,theHelper);
		}
	}

	private ArrayList<String> handleComOpenOrders(GetFNPCustomerDataDAO dao,
			String customerNumber, CustomerInformation customerInformation,
			FNPInformationHolder infoHolder, BksHelper theHelper) throws Exception {
		ArrayList<String> orderIdList = new ArrayList<String>();
		ArrayList<HashMap<String, Object>> openOrders = dao.getExternalOrders(customerNumber);
		for (int i = 0;openOrders!=null && i < openOrders.size(); i++) {
			String orderId = (String) openOrders.get(i).get("ORDER_ID");
			BigDecimal orderPosId = (BigDecimal) openOrders.get(i).get("ORDER_POSITION_NUMBER");
			OpenOrder oo = getOpenOrders(orderId, orderPosId);
			if (oo != null){
				customerInformation.getOpenOrder().add(oo);
				orderIdList.add(orderId);
			}
		}
		return orderIdList;
	}

	private OpenOrder getOpenOrders(String orderId,BigDecimal orderPosId) throws Exception{
		ApplicationContext ac = DatabaseClient.getAc();
		if (ac == null)
			throw new MCFException("Application context has not been initialized.");
		OpenOrder openOrder = new OpenOrder();
		int timeToLive = 3600000;
		int timeOut = 100000;
		try {
			timeToLive = Integer.parseInt(DatabaseClientConfig.getSetting("servicebusclient.TimeToLive"));
			timeOut = Integer.parseInt(DatabaseClientConfig.getSetting("servicebusclient.TimeOut"));
		} catch (Exception e1) {
			// Ignore (Use Default)
		}
		try {
			GetOrderDetailsRequest request = new GetOrderDetailsRequest();
			request.setOrderID(orderId);
			request.setOrderPositionNumber(orderPosId);
			request.setOrderOutputFormat(OrderOutputFormat.SIDCOM);
			request.setReturnUnenrichedOrder(true);
			ServiceRequestSoap<GetOrderDetailsRequest> serviceRequest =
				new ServiceRequestSoap<GetOrderDetailsRequest>(request,
						"classpath:schema/COM-PROV-001.xsd",
				"de.vodafone.esb.service.sbus.com.com_prov_001");
			serviceRequest.setOperationName("/COM-001/GetOrderDetails");		
			serviceRequest.setTimeToLive(timeToLive);
			ServiceResponse<GetOrderDetailsResponse> respServ = messageSender.sendSyncSoapRequest(serviceRequest, timeOut);
			GetOrderDetailsResponse resp = respServ.getPayload();
			Node xml = (Node)resp.getOrderDetails().getAny();
//			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
//			DOMImplementationLS impl = 
//			    (DOMImplementationLS)registry.getDOMImplementation("LS");
//			LSSerializer writer = impl.createLSSerializer();
//			String text = writer.writeToString(xml);
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			StringWriter buffer = new StringWriter();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.transform(new DOMSource(xml),
			      new StreamResult(buffer));
			String text = buffer.toString();
			XmlProcessor xmlProcessor = (XmlProcessor) ac.getBean("mcf2XmlProcessor");
			Object order1 = xmlProcessor.deserialize(text, "schema/SIDCOM-FNPOrder-001.xsd", "de.vodafone.esb.schema.common.sidcom_fnporder_001");
			Object order = ((JAXBElement)order1).getValue();
			if (((BackendOrder)order).getOrderItem()==null || ((BackendOrder)order).getOrderItem().size() ==0)
				return null;
			OrderItem oi = ((BackendOrder)order).getOrderItem().get(0);
			String custIntention = oi.getCustomerIntention();
			ProductOfferingOccurrence poo = null;
			if( oi.getProductOfferingOccurrenceToBe()==null) {
				if (oi.getProductOfferingOccurrenceAsIs() != null && 
					custIntention.equals("Terminate"))
					poo = oi.getProductOfferingOccurrenceAsIs();
				else
					return null;
			} else 
			   poo = oi.getProductOfferingOccurrenceToBe();
			ArrayList<String> gciList = BksRefDataCacheHandler.getGeneralData().get("BLOCK_INTE");
//			if (!gciList.contains(custIntention))
//				return null;
			openOrder.setCustomerOrderId("dummydummy");
			openOrder.setOrderId(orderId);
			if (custIntention.equals("Terminate"))
				openOrder.setOrderItemType("Terminate");
			else if (custIntention.equals("CreateNewLine"))
				openOrder.setOrderItemType("Create");
			else
				openOrder.setOrderItemType("Change");
			openOrder.getProductOfferingToBe().add(poo);
		} catch (Exception e) {
			log.warn("Call to Com failed. Message: "+e.getMessage());
			return null;
		}
		return  openOrder;
	}

	private void populateOrderInfo(GetFNPCustomerDataDAO dao,
			HashMap<String, Object> openOrder, CustomerInformation customerInformation, String requestType, FNPInformationHolder infoHolder, BksHelper theHelper) throws Exception {
		customerInformation.getOpenOrder().add(new OpenOrder());
		int lastIndex = customerInformation.getOpenOrder().size() - 1;
		String custOrderId = (String) openOrder.get("CUSTOMER_ORDER_ID");
		String barCode = (String) openOrder.get("CUSTOMER_TRACKING_ID");
		ArrayList<HashMap<String, Object>> openTickets =dao.getOrderTickets(custOrderId);
		String orderType = "Create";
		boolean isDslr = false;
		for (int i=0;openTickets != null && i<openTickets.size();i++) {
			theHelper.setDesiredNewElement(0);
			String usageMode = (String)openTickets.get(i).get("USAGE_MODE_VALUE_RD");
			if (usageMode.equals("4"))
				orderType = "Terminate";
			if (usageMode.equals("2") && !orderType.equals("Terminate"))
				orderType = "Change";

			theHelper.setDesiredNewElement(1);
			String servSubsId = (String)openTickets.get(i).get("SERVICE_SUBSCRIPTION_ID");
			String serviceCode = (String)openTickets.get(i).get("SERVICE_CODE");
			if (serviceCode.equals("I1043")||serviceCode.equals("I104A"))
				isDslr = true;
			String ticketId = (String)openTickets.get(i).get("SERVICE_TICKET_POSITION_ID");
			if (serviceCode.equals("VI201") && requestType.equals("CPD")&&!isDslr){
				String errorText = "Voip 2end line is not supported.";
				String errorCode = "BKSCOM-ERROR-000026";
				throw new BksDataException(errorCode,errorText);
			}
			infoHolder.setVoice(false);
			if (Arrays.asList(voiceServices).contains(serviceCode))
				infoHolder.setVoice(true);
			if (serviceCode.equals("V0100") && doesVoiceNodeExist(customerInformation))
				theHelper.setDesiredNewElement(2);
			String productCode = populateTableData(dao,servSubsId,serviceCode,customerInformation,true, infoHolder, theHelper);
			populateConfiguredValues(dao,null,ticketId,productCode,serviceCode,null,customerInformation,true,infoHolder.isVoice(), theHelper,requestType,true);
			populateAccessNumbers(dao,null,ticketId,serviceCode,null,customerInformation,true,infoHolder.isVoice(), theHelper);
			if (infoHolder.isVoice())
				handleOpenOrderSpecialServices(dao,openTickets,servSubsId, customerInformation, theHelper);
		}
		int poIndex = customerInformation.getOpenOrder().get(lastIndex).getProductOfferingToBe().size();
		if (infoHolder.hasRelevantServices()&& poIndex > 0){
			customerInformation.getOpenOrder().get(lastIndex).setCustomerOrderId(custOrderId);
			customerInformation.getOpenOrder().get(lastIndex).setOrderId(barCode);
			customerInformation.getOpenOrder().get(lastIndex).setOrderItemType(orderType);
			ProductOfferingOccurrence poo = 
				customerInformation.getOpenOrder().get(lastIndex).getProductOfferingToBe().get(poIndex-1);
			if (poo.getProductOfferingCode() == null && infoHolder.isVoice()){
				poo.setProductOfferingCode("voice");
				poo.setProductOfferingName(getVoicePOName(customerInformation));
				poo.getProductBundle().setSpecification("fixedNetVoice");
			}
		} else {
			customerInformation.getOpenOrder().remove(lastIndex);
		}
	}

	private String getVoicePOName(CustomerInformation customerInformation) {
		List<ProductOfferingSubscription> pos = customerInformation.getProductOfferingSubscription();
		for (int i=0;i<pos.size();i++){
			if (pos.get(i).getProductOfferingCode().equals("voice"))
				return pos.get(i).getProductOfferingName();
		}
		return "";
	}

	private boolean doesVoiceNodeExist(CustomerInformation customerInformation) {
		int lastIndex = customerInformation.getOpenOrder().size() - 1;
		int poIndex = customerInformation.getOpenOrder().get(lastIndex).getProductOfferingToBe().size();
		if ( poIndex == 0)
			return false;
		ProductOfferingOccurrence poo = 
			customerInformation.getOpenOrder().get(lastIndex).getProductOfferingToBe().get(poIndex-1);
		if (poo.getProductOfferingCode().equals("voice"))
			return true;
		return false;
	}

	private void handleOpenOrderSpecialServices(GetFNPCustomerDataDAO dao,
			ArrayList<HashMap<String, Object>> openTickets, String parentServSubsId,
			CustomerInformation customerInformation,  BksHelper theHelper) throws Exception {
		String pathPrefix = "OpenOrder.ProductOfferingToBe.ProductBundle.ProductBundleOrProduct.";
		ArrayList<HashMap<String, Object>> services = dao.getChildServices(parentServSubsId,"INTERNATIONAL","ORDERED");
		if (services != null && services.size() > 0) {
			theHelper.setDesiredNewElement(2);
			theHelper.setAttributeForPath(customerInformation,"set",pathPrefix+"Specification","vodafoneInternational");
			for (int i = 0; i < services.size(); i++) {
				theHelper.setDesiredNewElement(3);
				String serviceCode = (String) services.get(i).get("SERVICE_CODE");
				String serviceName = (String) services.get(i).get("SERVICE_NAME");
				if (!isServiceInStpList(openTickets,serviceCode))
					continue;
				theHelper.setAttributeForPath(customerInformation,"set",pathPrefix+"CharacteristicValue.Name","country");
				theHelper.setAttributeForPath(customerInformation,"set",pathPrefix+"CharacteristicValue.StringValue",serviceCode);
				theHelper.setAttributeForPath(customerInformation,"set",pathPrefix+"CharacteristicValue.MappedValue",serviceName);
			}
		}
		services.clear();
		services = dao.getChildServices(parentServSubsId,"TARIFF_OPTION","ORDERED");
		if (services != null && services.size() > 0) {
			theHelper.setDesiredNewElement(2);
			theHelper.setAttributeForPath(customerInformation,"set",pathPrefix+"Specification","chargingOptions");
			for (int i = 0; i < services.size(); i++) {
				theHelper.setDesiredNewElement(3);
				String serviceCode = (String) services.get(i).get("SERVICE_CODE");
				String serviceName = (String) services.get(i).get("SERVICE_NAME");
				if (!isServiceInStpList(openTickets,serviceCode))
					continue;
				theHelper.setAttributeForPath(customerInformation,"set",pathPrefix+"CharacteristicValue.Name","tariffOption");
				theHelper.setAttributeForPath(customerInformation,"set",pathPrefix+"CharacteristicValue.StringValue",serviceCode);
				theHelper.setAttributeForPath(customerInformation,"set",pathPrefix+"CharacteristicValue.MappedValue",serviceName);
			}
		}
	}

	private boolean isServiceInStpList(
			ArrayList<HashMap<String, Object>> openTickets, String serviceCode) {
		for (int i = 0; i < openTickets.size(); i++) {
			String ticketCode = (String) openTickets.get(i).get("SERVICE_CODE");
			if (ticketCode.equals(serviceCode))
				return true;
		}
		return false;
	}

	private void populateSalesPackageInfo(GetFNPCustomerDataDAO dao,
			String bundleId, CustomerInformation customerInformation) throws Exception  {
		ArrayList<HashMap<String, Object>> salesPackectInfo = dao.getSalesPackageInfo(bundleId);
		String packetCode = "none";
		String packetName = "none";
		if (salesPackectInfo != null && salesPackectInfo.size() > 0) {
			packetCode = (String) salesPackectInfo.get(0).get("SALES_PACKET_CODE");
			packetName = (String) salesPackectInfo.get(0).get("SALES_PACKET_NAME");
		}
		CustomerInformation.ProductOfferingSubscription pos = 
			new CustomerInformation.ProductOfferingSubscription();
		pos.setProductOfferingCode(packetCode);
		pos.setProductOfferingName(packetName);
		customerInformation.getProductOfferingSubscription().add(pos);
	}
	private void populateProductOffering(GetFNPCustomerDataDAO dao,
			String requestType, ArrayList<HashMap<String, Object>>bundleItems, 
                        CustomerInformation customerInformation, FNPInformationHolder infoHolder, BksHelper theHelper) throws Exception {
		ArrayList<String> subIds = new ArrayList<String>();
		String internetAccessId = null;
		boolean isDslr = false;
		for (int i =0;bundleItems!=null&&i<bundleItems.size();i++) {
			infoHolder.setVoice(false);
			String servSubsId = bundleItems.get(i).get("SUPPORTED_OBJECT_ID").toString();
			String bundleItemType = bundleItems.get(i).get("BUNDLE_ITEM_TYPE_RD").toString();
			if (subIds.contains(servSubsId))
				continue;
			subIds.add(servSubsId);
			String serviceCode = bundleItems.get(i).get("SERVICE_CODE").toString();
			if (serviceCode.equals("I1043")||serviceCode.equals("I104A"))
				isDslr = true;
			theHelper.setDesiredNewElement(1);
			if (Arrays.asList(voiceServices).contains(serviceCode)){
				infoHolder.setVoice(true);
			}
			if (Arrays.asList(accessServices).contains(serviceCode)){
				internetAccessId = servSubsId;
			}
			String productCode = populateTableData(dao,servSubsId,serviceCode,customerInformation,false,infoHolder, theHelper);
			if (productCode.equals("VI201") && requestType.equals("CPD") && !isDslr){
				String errorText = "Voip 2end line is not supported.";
				String errorCode = "BKSCOM-ERROR-000026";
				throw new BksDataException(errorCode,errorText);
			}

			PopulateProductPrice(dao,servSubsId,"-",customerInformation,infoHolder.isVoice(),theHelper);
			if (bundleItemType.equals("ONLINE_SERVICE") || bundleItemType.equals("DSLONL_SERVICE")){
				populateConfiguredValues(dao,internetAccessId,null,productCode,serviceCode,null,customerInformation,false,false, theHelper,null,false);
				populateChildServiceList(dao,productCode,internetAccessId,serviceCode,
						customerInformation,infoHolder.isVoice(),theHelper);
			}
			if (Arrays.asList(voipServices).contains(serviceCode)){
				populateConfiguredValues(dao,internetAccessId,null,productCode,serviceCode,null,customerInformation,false,true, theHelper,null,false);
			}
			populateAddressChars(dao,servSubsId,productCode,serviceCode,customerInformation,theHelper);
			populateAccessNumbers(dao,servSubsId,null,serviceCode,null,customerInformation,false,infoHolder.isVoice(), theHelper);
			populateConfiguredValues(dao,servSubsId,null,productCode,serviceCode,null,customerInformation,false,infoHolder.isVoice(), theHelper,null,true);
			theHelper.setDesiredNewElement(2);
			populateChildServiceList(dao,productCode,servSubsId,null,customerInformation,infoHolder.isVoice(),theHelper);
			if (Arrays.asList(internetServices).contains(serviceCode))
				defaultUpstreamIfNotPopulated(customerInformation);
			if (infoHolder.isVoice()){
				populateSpecialServices(dao,servSubsId,"INTERNATIONAL","country","vodafoneInternational",customerInformation,theHelper);
				populateSpecialServices(dao,servSubsId,"TARIFF_OPTION","tariffOption","chargingOptions",customerInformation,theHelper);
			}
			if (serviceCode.equals("I1305"))
				populateTvCenterTarifOption(dao,servSubsId,customerInformation,theHelper);
			if (serviceCode.equals("I1290"))
				populateVolumeCaps(dao,servSubsId,customerInformation,theHelper);
			theHelper.setDesiredNewElement(1);
			populateDepHardwareList(dao,productCode,servSubsId,null,customerInformation,theHelper,requestType);
		}
	}

	private void populateVolumeCaps(GetFNPCustomerDataDAO dao,
			String parentServSubsId, CustomerInformation customerInformation,
			BksHelper theHelper) throws Exception {
		ArrayList<HashMap<String, Object>> services = dao.getChildServices(parentServSubsId,"VOLUME_CAP","SUBSCRIBED");
		if (services!=null && services.size() > 0) {
			theHelper.setDesiredNewElement(2);
			String serviceCode = (String) services.get(0).get("SERVICE_CODE");
			String serviceName = (String) services.get(0).get("SERVICE_BILLING_NAME");
			String prefix="ProductOfferingSubscription.ProductOfferingOccurrence.Product.CharacteristicValue.";
			theHelper.setAttributeForPath(customerInformation,"set",prefix+"Name","volumeCap");
			theHelper.setAttributeForPath(customerInformation,"set",prefix+"StringValue",serviceCode);
			theHelper.setAttributeForPath(customerInformation,"set",prefix+"MappedValue",serviceName);
		}
	}

	private void PopulateProductPrice(GetFNPCustomerDataDAO dao,
			String servSubsId, String productCode, CustomerInformation customerInformation, 
			boolean isVoice, BksHelper theHelper) throws Exception {
		ArrayList<HashMap<String, Object>>priceServs = dao.getProductPrice(servSubsId);
		for (int i =0;priceServs!=null&&i<priceServs.size();i++) {
			theHelper.setDesiredNewElement(1);
			String priceServSubsId = priceServs.get(i).get("SERVICE_SUBSCRIPTION_ID").toString();
			String priceServSubsCode = priceServs.get(i).get("SERVICE_CODE").toString();
			HashMap<String, ArrayList<String[]>> tableColMap = 
				BksRefDataCacheHandler.getSidTableColumnMap().get(productCode+";"+priceServSubsCode);
			if (tableColMap != null) {
				Set<String> keys = tableColMap.keySet();
				Iterator<String> keyiter = keys.iterator();
				while (keyiter.hasNext()){
					String columnName = keyiter.next();
					if (columnName.equals("-")){
						for (int j = 0; j < tableColMap.get(columnName).size(); j++) {
							String path = (String) tableColMap.get(columnName).get(j)[0];
							theHelper.setAttributeForPath(customerInformation, "set", path, tableColMap.get(columnName).get(j)[1].toString());
						}
						continue;
					}
					if (priceServs.get(i).get(columnName)==null)
						continue;
					for (int j = 0; j < tableColMap.get(columnName).size(); j++) {
						String columnValue = priceServs.get(i).get(columnName).toString();
						if (tableColMap.get(columnName).get(j)[2] != null)
							columnValue = tableColMap.get(columnName).get(j)[2] + columnValue;
						String conversionMethod = tableColMap.get(columnName).get(j)[1];
						if (conversionMethod != null) {
							Object converted = theHelper.invokeMethod(
									theHelper, conversionMethod, columnValue,
									String.class);
							theHelper.setAttributeForPath(customerInformation, "set", tableColMap
									.get(columnName).get(j)[0], converted);
						} else {
							theHelper.setAttributeForPath(customerInformation, "set", tableColMap
									.get(columnName).get(j)[0], columnValue);
						}
					}
				}
			}
			populateConfiguredValues(dao,priceServSubsId,null,"-",priceServSubsCode,null,customerInformation,false,isVoice, theHelper,null,true);
		}
	}

	private void populateAddressChars(GetFNPCustomerDataDAO dao,
			String servSubsId, String productCode,
			String serviceCode, CustomerInformation customerInformation, BksHelper theHelper) throws Exception {
		ArrayList<HashMap<String, Object>> addresses = dao.getAddressChar(servSubsId);
		if (addresses == null)
			return;
		HashMap<String,HashMap<String,Object>> charMap = BksRefDataCacheHandler.getSidServiceColumnMap().get(productCode+";"+serviceCode);
		if (charMap==null)
			charMap = BksRefDataCacheHandler.getSidServiceColumnMap().get("-;"+serviceCode);
		for (int i =0;charMap!=null&&i<addresses.size();i++) {
			String serviceCharCode = (String) addresses.get(i).get("SERVICE_CHARACTERISTIC_CODE");
			if (charMap.get(serviceCharCode) != null){
				Set<String> keys = charMap.get(serviceCharCode).keySet();
				Iterator<String> keyiter = keys.iterator();
				while (keyiter.hasNext()){
					String columnName = keyiter.next();
					String columnValue = (String) addresses.get(i).get(columnName);
					Object valueObj = charMap.get(serviceCharCode).get(columnName);
					if (!(valueObj instanceof ArrayList)){
						if (columnValue == null)
							continue;
						populateSingleColumn((String[])valueObj,columnValue,customerInformation,theHelper);
					} else {
						ArrayList<String[]> list = (ArrayList<String[]>)valueObj;
						for (int j = 0; list != null && j < list.size(); j++) {
							String[] item = list.get(j);
							if (columnValue == null)
								continue;
							populateSingleColumn(item,columnValue,customerInformation,theHelper);
						}
					}
				}
			}
		}
	}

	private void populateSingleColumn(String[] valueObj, String columnValue,
			CustomerInformation customerInformation, BksHelper theHelper) throws Exception {
		String path = valueObj[0];
		String conversionMethod = valueObj[1];
		String fieldNumber = valueObj[2];
		if (path != null && columnValue != null){
			if (fieldNumber != null)
				columnValue = getPartValue(columnValue,Integer.parseInt(fieldNumber));
			if (conversionMethod == null) {
				String value = (String)	theHelper.setAttributeForPath(customerInformation, "get",path, null);
				if (value == null)
					theHelper.setAttributeForPath(customerInformation, "set", path, columnValue);
				else{
					Pattern p = Pattern.compile("[a-zA-Z]*");
					Matcher m = p.matcher(value);
					boolean b = m.matches();
					if (b)
						value = columnValue + value;
					else
						value = value + columnValue;
					theHelper.setAttributeForPath(customerInformation, "set", path, value);
				}
			} else {
				if (columnValue.trim().length() != 0){
					Object converted = theHelper.invokeMethod(theHelper, conversionMethod, columnValue, String.class);
					theHelper.setAttributeForPath(customerInformation, "set", path, converted);
				}
			}
		}
	}

	private String getPartValue(String columnValue, int fieldNumber) {
		int i=0;
        for (;i<columnValue.length()&&Character.isDigit(columnValue.charAt(i));i++);
        if (fieldNumber == 1 && i<=columnValue.length())
        	return columnValue.substring(0,i);
        if (fieldNumber != 1 && i<columnValue.length())
        	return columnValue.substring(i,columnValue.length());
		return "";
	}

	private void populateDepHardwareList(GetFNPCustomerDataDAO dao,
			String productCode, String parentServSubsId, String parentServiceCode,
			CustomerInformation customerInformation, BksHelper theHelper, String requestType) throws Exception {
		ArrayList<HashMap<String, Object>> services = dao.getHardwareDepService(parentServSubsId);
		if (services == null || services.size() == 0)
			return;
		populateDependentFunctions(dao,services,productCode,parentServiceCode,customerInformation,true,false,theHelper,requestType);
	}

	private void populateChildServiceList(GetFNPCustomerDataDAO dao,
			String productCode, String parentServSubsId, String parentServiceCode,
			CustomerInformation customerInformation, boolean isVoice, BksHelper theHelper) throws Exception {
		ArrayList<HashMap<String, Object>> services = dao.getChildServices(parentServSubsId,null,"SUBSCRIBED");
		if (services == null || services.size() == 0)
			return;
		populateDependentFunctions(dao,services,productCode,parentServiceCode,customerInformation,false,isVoice,theHelper,null);
		populateSubscriptionExistance(services,productCode,null,customerInformation, theHelper);
	}

	private void defaultUpstreamIfNotPopulated(CustomerInformation customerInformation) {
		List<ProductOfferingSubscription> posList = customerInformation.getProductOfferingSubscription();
		if (posList==null||posList.size()==0)
			return;
		int posIndex = posList.size()-1;
		ProductOfferingSubscription pos = posList.get(posIndex);
		List<ProductOfferingOccurrence> pooList = pos.getProductOfferingOccurrence();
		if (pooList==null||pooList.size()==0)
			return;
		int pooIndex = pooList.size()-1;
		ProductOfferingOccurrence poo = pooList.get(pooIndex);
		Product pr = poo.getProduct();
		List<CharacteristicValue> charlist = pr.getCharacteristicValue();
		for (int i = 0; i < charlist.size(); i++) {
			if(charlist.get(i).getName().equals("upstreamBandwidth") &&
					charlist.get(i).getStringValue() != null)
				return;
		}
		CharacteristicValue cv = new CharacteristicValue();
		cv.setName("upstreamBandwidth");
		cv.setStringValue("Standard");
		charlist.add(cv);
	}

	private void populateTvCenterTarifOption(GetFNPCustomerDataDAO dao,
			String parentServSubsId, CustomerInformation customerInformation, BksHelper theHelper) throws Exception {
		ArrayList<HashMap<String, Object>> services = dao.getChildServices(parentServSubsId,null,"SUBSCRIBED");
		final String[] tarifServices = {	"I1354","I1355","I6011","I6012","I6013","I6014",
											"I6015","I6016","I6017","I6018","I6019","I6020",
											"I6101","I6102","I6103","I6104","I6105","I6106",
											"I6107","I6108","I6109","I6110","I6201","I6202",
											"I6203","I6204","I6205","I6211","I6212","I6213",
											"I6214","I6215","V0303","I1351"};
		String prefix = "ProductOfferingSubscription.ProductOfferingOccurrence.ProductBundle.ProductBundleOrProduct.CustomerFacingService.";
		String charValuePrefix = prefix+"CharacteristicValue.";
		
		if (services != null && services.size() > 0) {
			theHelper.setDesiredNewElement(2);
			theHelper.setAttributeForPath(
					        customerInformation,
							"set",
							"ProductOfferingSubscription.ProductOfferingOccurrence.ProductBundle.ProductBundleOrProduct.Specification",
							"chargingOptions");
			for (int i = 0; i < services.size(); i++) {
				theHelper.setDesiredNewElement(3);
				String serviceCode = (String) services.get(i).get("SERVICE_CODE");
				String servSubsId = (String) services.get(i).get("SERVICE_SUBSCRIPTION_ID");
				String serviceBillingName = (String) services.get(i).get("SERVICE_BILLING_NAME");
				if (!Arrays.asList(tarifServices).contains(serviceCode))
					continue;
				ArrayList<HashMap<String, Object>> configValues = null;
				if (servSubsId != null)
					configValues = dao.getConfiguredValues(servSubsId);
				Boolean hotSubs = getCharValue(configValues,"I1320", theHelper);
				boolean isDurationDefinedForService=false;
				theHelper.setAttributeForPath(customerInformation,"set",prefix + "Specification",serviceCode);
				theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "Name","Service Name");
				theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "StringValue",serviceBillingName);
			
				String startDate = null;
				String duration = null;
				boolean bNewNodeCreated = false;
				for(int j = 0; j < configValues.size(); j++){
					String serviceCharCode = (String) configValues.get(j).get("SERVICE_CHARACTERISTIC_CODE");
					final String[] tariffOptionChar = {"V0200","V0231","V0232"};
					
					if(Arrays.asList(tariffOptionChar).contains(serviceCharCode)){
						if(!bNewNodeCreated){
							theHelper.setDesiredNewElement(4);
							theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "Name","contractualObligation");
							theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "StringValue","minimumDuration");
							bNewNodeCreated = true;
						}

						String charValue = (String) configValues.get(j).get("CONFIGURED_VALUE_STRING");
						String conversionMethod = null;
						
						Object converted = null;
						if(serviceCharCode.equals("V0200")){
							conversionMethod = "convertCcbToDate";
							converted = theHelper.invokeMethod(theHelper,conversionMethod, charValue, String.class);
							startDate = charValue;

							theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "StartDate",converted);
						}
						
						if(serviceCharCode.equals("V0231")){
							isDurationDefinedForService=true;
							if(charValue == null)
								charValue = "0";
							conversionMethod = "convertToBigDecimal";
							converted = theHelper.invokeMethod(theHelper,conversionMethod, charValue, String.class);
							duration = charValue;
							
							theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "Duration",duration);
							theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "DurationUnit","MONTH");
						}
						
						if(serviceCharCode.equals("V0232")){
							conversionMethod = "convertOpmToDate";
							converted = theHelper.invokeMethod(theHelper,conversionMethod, charValue, String.class);
							
							theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "TerminationDate",converted);
						}
						
						if(startDate != null && duration != null){
							Object startDateCal = theHelper.convertCcbToDate(startDate);
							Object startDateDate = theHelper.convertCalendarToSqlDate(startDateCal);
							converted = theHelper.getContractEndDate(startDateDate,"MONTH", Integer.parseInt(duration), null,null,false);
							
							theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "EndDate",converted);
							
							startDate = null;
							duration = null;
						}
					}	
				}
				
				if (!isDurationDefinedForService){
					theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "Duration","0");
					theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "DurationUnit","MONTH");
				}

				if (hotSubs!=null) {
					theHelper.setDesiredNewElement(4);
					theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "Name","hotSubscription");
					theHelper.setAttributeForPath(customerInformation,"set",charValuePrefix + "BooleanValue",hotSubs);
				}
			}
		}
	}

	private Boolean getCharValue(
			ArrayList<HashMap<String, Object>> configValues, String charCode, BksHelper theHelper) {
		for (int i = 0;configValues!= null &&  i < configValues.size(); i++) {
			String dbCharCode = (String) configValues.get(i).get("SERVICE_CHARACTERISTIC_CODE");
			if (dbCharCode.equals(charCode)) {
				String value = (String) configValues.get(i).get("CONFIGURED_VALUE_STRING");
				return theHelper.convertToBoolean(value);
			}
		}
		return null;
	}

	private void populateSpecialServices(GetFNPCustomerDataDAO dao,
			String parentServSubsId,String serviceType,
			String charName,String spec,CustomerInformation customerInformation, BksHelper theHelper) throws Exception {
		ArrayList<HashMap<String, Object>> services = dao.getChildServices(parentServSubsId,serviceType,"SUBSCRIBED");
		String prefix = "ProductOfferingSubscription.ProductOfferingOccurrence.ProductBundle.ProductBundleOrProduct.";
		if (services != null && services.size() > 0) {
			theHelper.setDesiredNewElement(2);
			theHelper.setAttributeForPath(customerInformation,"set",prefix + "Specification",spec);
			for (int i = 0; i < services.size(); i++) {
				theHelper.setDesiredNewElement(3);
				String serviceCode = (String) services.get(i).get("SERVICE_CODE");
				String serviceName = (String) services.get(i).get("SERVICE_NAME");
				theHelper.setAttributeForPath(customerInformation,"set",prefix + "CharacteristicValue.Name",charName);
				theHelper.setAttributeForPath(customerInformation,"set",prefix + "CharacteristicValue.StringValue",serviceCode);
				theHelper.setAttributeForPath(customerInformation,"set",prefix + "CharacteristicValue.MappedValue",serviceName);
				if(serviceType.equals("TARIFF_OPTION")){
					String servSubsId = (String) services.get(i).get("SERVICE_SUBSCRIPTION_ID");
					ArrayList<HashMap<String, Object>> configValues = null;
					if(servSubsId != null)
						configValues = dao.getConfiguredValues(servSubsId);
					
					String startDate = null;
					String duration = null;
					boolean isDurationDefinedForService=false;

					for(int j = 0; j < configValues.size(); j++){
						String serviceCharCode = (String) configValues.get(j).get("SERVICE_CHARACTERISTIC_CODE");
						final String[] tariffOptionChar = {"V0200","V0231","V0232"};
						
						if(Arrays.asList(tariffOptionChar).contains(serviceCharCode)){
							String charValue = (String) configValues.get(j).get("CONFIGURED_VALUE_STRING");
							String conversionMethod = null;
							if(serviceCharCode.equals("V0200")){
								conversionMethod = "convertCcbToDate";
								Object converted = null;
								converted = theHelper.invokeMethod(theHelper,conversionMethod, charValue, String.class);
								startDate = charValue;
								
								theHelper.setAttributeForPath(customerInformation,"set",prefix + "CharacteristicValue.StartDate",converted);
							}
							
							if(serviceCharCode.equals("V0231")){
								isDurationDefinedForService=true;
								if(charValue == null)
									charValue = "0";
								conversionMethod = "convertToBigDecimal";
								Object converted = null;
								duration = charValue;
								converted = theHelper.invokeMethod(theHelper,conversionMethod, charValue, String.class);
								
								theHelper.setAttributeForPath(customerInformation,"set",prefix + "CharacteristicValue.Duration",duration);
								theHelper.setAttributeForPath(customerInformation,"set",prefix + "CharacteristicValue.DurationUnit","MONTH");
							}
							
							if(serviceCharCode.equals("V0232")){
								conversionMethod = "convertOpmToDate";
								Object converted = null;
								converted = theHelper.invokeMethod(theHelper,conversionMethod, charValue, String.class);
								
								theHelper.setAttributeForPath(customerInformation,"set",prefix + "CharacteristicValue.TerminationDate",converted);
							}

							if(startDate != null && duration != null){
								Object converted = null;
								Object startDateCal = theHelper.convertCcbToDate(startDate);
								Object startDateDate = theHelper.convertCalendarToSqlDate(startDateCal);
								converted = theHelper.getContractEndDate(startDateDate,"MONTH", Integer.parseInt(duration), null,null,false);

								theHelper.setAttributeForPath(customerInformation,"set",prefix + "CharacteristicValue.EndDate",converted);

								startDate = null;
								duration = null;

							}

						}

					}
                    if (!isDurationDefinedForService){
						theHelper.setAttributeForPath(customerInformation,"set",prefix + "CharacteristicValue.Duration","0");
						theHelper.setAttributeForPath(customerInformation,"set",prefix + "CharacteristicValue.DurationUnit","MONTH");
                    }
				}
			}
		}
	}
		
	

    private void populateChildContractData(String productCode,String serviceCode, HashMap<String, Object> service,
			String parentServiceCode, CustomerInformation customerInformation, BksHelper theHelper) throws Exception{
		HashMap<String, ArrayList<String[]>> tableColMap = null;
		if (parentServiceCode != null){
			tableColMap = BksRefDataCacheHandler.getSidTableColumnMap().get(productCode+";"+serviceCode+";"+parentServiceCode);
		    if (tableColMap==null)
		    	tableColMap = BksRefDataCacheHandler.getSidTableColumnMap().get("-;"+serviceCode+";"+parentServiceCode);
		} else {
			tableColMap = BksRefDataCacheHandler.getSidTableColumnMap().get(productCode+";"+serviceCode);
		    if (tableColMap==null)
		    	tableColMap = BksRefDataCacheHandler.getSidTableColumnMap().get("-;"+serviceCode);
		}
			
		if (tableColMap != null) {
			Set<String> keys = tableColMap.keySet();
			Iterator<String> keyiter = keys.iterator();
			while (keyiter.hasNext()){
				String columnName = keyiter.next();
				if (columnName.equals("-")){
					for (int j = 0; j < tableColMap.get(columnName).size(); j++) {
						String path = (String) tableColMap.get(columnName).get(j)[0];
						theHelper.setAttributeForPath(customerInformation, "set", path, tableColMap.get(columnName).get(j)[1].toString());
					}
					continue;
				}
				if (service.get(columnName)==null)
					continue;
				for (int j = 0; j < tableColMap.get(columnName).size(); j++) {
					String columnValue = service.get(columnName).toString();
					if (tableColMap.get(columnName).get(j)[2] != null)
						columnValue = tableColMap.get(columnName).get(j)[2] + columnValue;
					String conversionMethod = tableColMap.get(columnName).get(j)[1];
					if (conversionMethod != null) {
						Object converted = theHelper.invokeMethod(
								theHelper, conversionMethod, columnValue,
								String.class);
						theHelper.setAttributeForPath(customerInformation, "set", tableColMap
								.get(columnName).get(j)[0], converted);
					} else {
						theHelper.setAttributeForPath(customerInformation, "set", tableColMap
								.get(columnName).get(j)[0], columnValue);
					}
				}
			}
		}
    }

	private void populateDependentFunctions(GetFNPCustomerDataDAO dao,
			ArrayList<HashMap<String, Object>> services, String productCode,
			String parentServiceCode, CustomerInformation customerInformation, 
			boolean bIsHardware,boolean isVoice, BksHelper theHelper, String requestType) throws Exception {
		for (int i =0;i<services.size();i++) {
			String serviceCode = services.get(i).get("SERVICE_CODE").toString();
			String servSubsId = services.get(i).get("SERVICE_SUBSCRIPTION_ID").toString();
			theHelper.setDesiredNewElement(1);
			if (isVoice)
				theHelper.setDesiredNewElement(2);
			populateChildContractData(((bIsHardware)?"-":productCode), serviceCode, services.get(i), parentServiceCode, customerInformation, theHelper);
			if (populateConfiguredValues(dao,servSubsId,null,((bIsHardware)?"-":productCode),
					 serviceCode,parentServiceCode,customerInformation,false,isVoice, theHelper,requestType,true))
				continue;
			populateAddressChars(dao,servSubsId,productCode,serviceCode,customerInformation,theHelper);
			populateAccessNumbers(dao,servSubsId,null,serviceCode,parentServiceCode,customerInformation,false,isVoice, theHelper);
			if (bIsHardware) {
				theHelper.setDesiredNewElement(2);
				theHelper.setAttributeForPath(customerInformation, "set",
						"ProductOfferingSubscription.ProductOfferingOccurrence.Product.CharacteristicValue.Name", "rented");
				theHelper.setAttributeForPath(customerInformation, "set",
						"ProductOfferingSubscription.ProductOfferingOccurrence.Product.CharacteristicValue.BooleanValue", isHardwareRented(dao,servSubsId));
				ArrayList<HashMap<String, Object>> hwChildServs = dao.getChildServices(servSubsId,null,"SUBSCRIBED");
				for (int j = 0; j < hwChildServs.size(); j++) {
					String hwChildId = hwChildServs.get(j).get("SERVICE_SUBSCRIPTION_ID").toString();
					String hwChildCode = hwChildServs.get(j).get("SERVICE_CODE").toString();
					populateChildContractData("-", hwChildCode, hwChildServs.get(j), serviceCode, customerInformation, theHelper);
					if (populateConfiguredValues(dao,hwChildId,null,"-",
							hwChildCode,null,customerInformation,false,isVoice, theHelper,requestType,true))
						continue;
				}
				populateSubscriptionExistance(hwChildServs,productCode,serviceCode,customerInformation, theHelper);
			} else {
				ArrayList<HashMap<String, Object>> grChildServs = dao.getChildServices(servSubsId,null,"SUBSCRIBED");
				if (grChildServs != null && grChildServs.size() > 0)
					populateSubscriptionExistance(grChildServs,productCode,null,customerInformation, theHelper);
			}
		}
	}

	private Object isHardwareRented(GetFNPCustomerDataDAO dao, String servSubsId) throws Exception {
		ArrayList<HashMap<String, Object>> initialTicket = dao.getInitialTicketForService(servSubsId);
		if (initialTicket!=null && initialTicket.size() > 0) {
			String usageMode = (String) initialTicket.get(0).get("USAGE_MODE_VALUE_RD");
			if (usageMode.equals("6"))
				return true;
		}
		return false;
	}

	private void populateSubscriptionExistance(ArrayList<HashMap<String, Object>> services,String productCode,
			String parentServiceCode, CustomerInformation customerInformation, BksHelper theHelper) throws Exception {
		HashMap<String,Object[]> existSubs = BksRefDataCacheHandler.getSidServiceExistMap().get(productCode);
		for (int i =0;existSubs != null && i<services.size();i++) {
			String key = (String) services.get(i).get("SERVICE_CODE");
			if (existSubs.get(key)== null)
				key += ";"+parentServiceCode;
			if (existSubs.get(key) != null){
				theHelper.setDesiredNewElement(2);
				for (int j = 0; j < existSubs.get(key).length; j++) {
					String targetPath = (String) existSubs.get(key)[j++];
					String defaultValue = (String) existSubs.get(key)[j++];
					String conversionMethod = (String) existSubs.get(key)[j++]; // Skip intro
					if (conversionMethod != null) {
						Object converted = theHelper.invokeMethod(theHelper,
								conversionMethod, defaultValue, String.class);
						theHelper.setAttributeForPath(customerInformation,
								"set", targetPath, converted);
					} else {
						theHelper.setAttributeForPath(customerInformation,
								"set", targetPath, defaultValue);
					}
				}
			}
		}
	}

	private boolean populateConfiguredValues(GetFNPCustomerDataDAO dao,
			String servSubsId, String ticketId,String productCode,String serviceCode, String parentServiceCode,
			CustomerInformation customerInformation,boolean bOpenOrder, boolean isVoice, BksHelper theHelper, String requestType, boolean populateDefault) throws Exception {
		HashMap<String,ArrayList<String[]>> charPath = null;
		if (bOpenOrder){
			if (parentServiceCode == null){
				charPath = BksRefDataCacheHandler.getSidOpenServiceCharMap().get(productCode+";"+serviceCode);
				if (charPath==null)
					charPath = BksRefDataCacheHandler.getSidOpenServiceCharMap().get("-;"+serviceCode);
			} else {
				charPath = BksRefDataCacheHandler.getSidOpenServiceCharMap().get(productCode+";"+serviceCode+";"+parentServiceCode);
				if (charPath==null)
					charPath = BksRefDataCacheHandler.getSidOpenServiceCharMap().get("-;"+serviceCode+";"+parentServiceCode);
			}
		} else {
			if (parentServiceCode == null){
				charPath = BksRefDataCacheHandler.getSidServiceCharMap().get(productCode+";"+serviceCode);
				if (charPath==null)
					charPath = BksRefDataCacheHandler.getSidServiceCharMap().get("-;"+serviceCode);
			} else {
				charPath = BksRefDataCacheHandler.getSidServiceCharMap().get(productCode+";"+serviceCode+";"+parentServiceCode);
				if (charPath==null)
					charPath = BksRefDataCacheHandler.getSidServiceCharMap().get("-;"+serviceCode+";"+parentServiceCode);
			}
		}
		if (charPath==null)
			return false;

		ArrayList<HashMap<String, Object>> configValues = null;
		if (servSubsId != null)
			configValues = dao.getConfiguredValues(servSubsId);
		else if (ticketId != null)
			configValues = dao.getConfiguredValuesByStp(ticketId);
		if (configValues == null)
			return false;
		boolean bLocationTAEFound = false;
		Set<String> keys = charPath.keySet();
		Iterator<String> keyiter = keys.iterator();
		while (keyiter.hasNext()){
			String refCharCode = keyiter.next();
			String columnValue = null;
			String serviceCharCode = null;
			for (int i = 0;i < configValues.size() && columnValue == null; i++) {
				serviceCharCode = (String) configValues.get(i).get("SERVICE_CHARACTERISTIC_CODE");
				if (refCharCode.equals(serviceCharCode))
					columnValue = (String) configValues.get(i).get("CONFIGURED_VALUE_STRING");
			}
			boolean bJumpoverChar = false;
			if (columnValue == null) {
				for (int j = 0; j < charPath.get(refCharCode).size(); j++) {
					String defaultValue = charPath.get(refCharCode).get(j)[5];
					String fixedValue = charPath.get(refCharCode).get(j)[6];
					if (fixedValue == null && defaultValue==null)
						bJumpoverChar = true;
				}
			}
			if (bJumpoverChar)
				continue;
			theHelper.setDesiredNewElement(2);
			if (isVoice || serviceCode.equals("I1305"))
				theHelper.setDesiredNewElement(3);
			String[] toplevelChars = {"V0123","V0127","V0128","V0129","V0130"};
			if (Arrays.asList(toplevelChars).contains(refCharCode))
				theHelper.setDesiredNewElement(-1);
			for (int j = 0; j < charPath.get(refCharCode).size(); j++) {
				String rdsId = charPath.get(refCharCode).get(j)[1];
				String conversionMethod = charPath.get(refCharCode).get(j)[2];
				String fieldNumber = charPath.get(refCharCode).get(j)[3];
				String defaultValue = charPath.get(refCharCode).get(j)[5];
				String fixedValue = charPath.get(refCharCode).get(j)[6];
				String introVersion = charPath.get(refCharCode).get(j)[7];
				if (introVersion != null && introVersion.compareTo("BKS-005") > 0 )
					continue;
				String charValue = columnValue;
				if (!populateDefault && (columnValue == null||refCharCode.equals("V0124")))
					break;
				if (fixedValue != null)
					charValue=fixedValue;
				else if (columnValue == null && populateDefault)
					charValue=defaultValue;
				if (charValue == null)
					continue;
				if (fieldNumber != null){
					if (conversionMethod != null) {
						String converted = (String)theHelper.invokeMethod(theHelper,
								conversionMethod, charValue, String.class);
						if (converted == null)
							continue;
						conversionMethod = null;
						charValue = converted;
					}
					String[] fields = charValue.split(",");
					if (fields.length >= Integer.parseInt(fieldNumber)){
						charValue = fields[Integer.parseInt(fieldNumber)-1];
					} else
						continue;
				}
				if (rdsId == null && conversionMethod == null)
					theHelper.setAttributeForPath(customerInformation, "set",
							charPath.get(refCharCode).get(j)[0], charValue);
				else if (conversionMethod != null) {
					Object converted = theHelper.invokeMethod(theHelper,
							conversionMethod, charValue, String.class);
					if (converted!=null)
						theHelper.setAttributeForPath(customerInformation, "set",
								charPath.get(refCharCode).get(j)[0], converted);
				}
			}
			if (serviceCharCode!=null && serviceCharCode.equals("V0123") && columnValue != null)
				bLocationTAEFound = true;
			if (serviceCharCode!=null && serviceCharCode.equals("V0112")){
				HashMap<String,String>  articleFilter = new HashMap<String, String>();
				articleFilter.put("Artikelnummer",columnValue);
				String hardwareType = theHelper.getRefdataValue(articleFilter, "Hardwareartikel", "typ");
				String hardwareDesc = theHelper.getRefdataValue(articleFilter, "Hardwareartikel", "Bezeichnung");
				String[] allowedHardwareTypes = {"M","IAD","STB","EG"};
				String[] filterReqTypes = {"CPD","ICS"};
				if (hardwareType==null || (!Arrays.asList(allowedHardwareTypes).contains(hardwareType)
						&& Arrays.asList(filterReqTypes).contains(requestType))) {
					log.debug("The hardware service with article number "
							+columnValue+" has type of "+hardwareType+". It will be filtered out");
					if (bOpenOrder) {
						List<OpenOrder> pos = customerInformation.getOpenOrder();
						int lastIndex = pos.size() - 1;
						List<ProductOfferingOccurrence> productOccurances = pos.get(lastIndex).getProductOfferingToBe();
						lastIndex = productOccurances.size() - 1;
						productOccurances.remove(lastIndex);
					} else {
						List<ProductOfferingSubscription> pos = customerInformation.getProductOfferingSubscription();
						int lastIndex = pos.size() - 1;
						List<ProductOfferingOccurrence> productOccurances = pos.get(lastIndex).getProductOfferingOccurrence();
						lastIndex = productOccurances.size() - 1;
						productOccurances.remove(lastIndex);
					}
					return true;
				}
				if(hardwareType.equals("M"))
					hardwareType="Modem";
				if (bOpenOrder){
					List<OpenOrder> pos = customerInformation.getOpenOrder();
					int lastIndex= pos.size()-1;
					CharacteristicValue item = new CharacteristicValue();
					List<ProductOfferingOccurrence> productOffering = pos.get(lastIndex).getProductOfferingToBe();
					lastIndex= productOffering.size()-1;
					item.setName("type");
					item.setStringValue(hardwareType);
					productOffering.get(lastIndex).getProduct().getCharacteristicValue().add(item);
					item = new CharacteristicValue();
					item.setName("name");
					item.setStringValue(hardwareDesc);
					productOffering.get(lastIndex).getProduct().getCharacteristicValue().add(item);
				} else {
					List<ProductOfferingSubscription> pos = customerInformation.getProductOfferingSubscription();
					int lastIndex= pos.size()-1;
					CharacteristicValue item = new CharacteristicValue();
					List<ProductOfferingOccurrence> productOccurances = pos.get(lastIndex).getProductOfferingOccurrence();
					lastIndex= productOccurances.size()-1;
					item.setName("type");
					item.setStringValue(hardwareType);
					productOccurances.get(lastIndex).getProduct().getCharacteristicValue().add(item);
					item = new CharacteristicValue();
					item.setName("name");
					item.setStringValue(hardwareDesc);
					productOccurances.get(lastIndex).getProduct().getCharacteristicValue().add(item);
				}
			}
		}
		String[] accessServices = {"V0003","V0010","V0011","V0012","I1209","I1210","I1213","V0004","V0002","V0001","I1043","I1290","I121z"};
		if (!bLocationTAEFound && Arrays.asList(accessServices).contains(serviceCode) && !bOpenOrder){
			List<ProductOfferingSubscription> subList = customerInformation.getProductOfferingSubscription();
			int lastIndex = subList.size() - 1;
			ProductOfferingSubscription sub = subList.get(lastIndex);
			if (sub.getInstallationSite() == null)
				sub.setInstallationSite(new GermanPropertyAddress());
			DetachedHouse detachedHaous = new DetachedHouse();
			detachedHaous.setDetails(" ");
			sub.getInstallationSite().setDetachedHouse(detachedHaous);
		}
		return false;
	}

	private void populateAccessNumbers(GetFNPCustomerDataDAO dao,
			String servSubsId, String ticketId, String serviceCode, Object object,
			CustomerInformation customerInformation,boolean bOpenOrder, boolean isVoice, BksHelper theHelper) throws Exception {
		HashMap<String,HashMap<Integer,Object[]>> charMap = null;
		HashMap<String,String[]> accessName = null;
		if (bOpenOrder) {
			charMap = BksRefDataCacheHandler.getSidOpenServiceFieldMap().get(
					serviceCode);
			accessName = BksRefDataCacheHandler.getSidOpenAccessName();
		} else {
			charMap = BksRefDataCacheHandler.getSidServiceFieldMap().get(
					serviceCode);
			accessName = BksRefDataCacheHandler.getSidAccessName();
		}
		if (charMap == null || accessName == null)
			return;
		ArrayList<HashMap<String, Object>> accessNumbers=null;
		if (servSubsId != null)
			accessNumbers = dao.getAccessNumberChars(servSubsId);
		else if (ticketId != null)
			accessNumbers = dao.getAccessNumberCharsByStp(ticketId);

		for (int i =0;accessNumbers!=null&&i<accessNumbers.size();i++) {
			theHelper.setDesiredNewElement(2);
			if (isVoice)
				theHelper.setDesiredNewElement(3);
			String serviceCharCode = (String) accessNumbers.get(i).get("SERVICE_CHARACTERISTIC_CODE");
			String number = (String) accessNumbers.get(i).get("ACCESS_NUMBER");
			if (number == null)
				continue;
			String fixedPath;
			String fixedValue;
			if (accessName.containsKey(serviceCode + ";" + serviceCharCode)) {
				fixedPath = accessName.get(serviceCode + ";" + serviceCharCode)[0];
				fixedValue = accessName
						.get(serviceCode + ";" + serviceCharCode)[1];
				if (fixedPath != null && fixedValue != null)
					theHelper.setAttributeForPath(customerInformation, "set",
							fixedPath,fixedValue);
			}
			if (charMap.get(serviceCharCode) != null){
				HashMap<Integer,Object[]> fieldPathMap = charMap.get(serviceCharCode);
				String[] numberFields = number.split(";");
				for(Integer j=0;j<numberFields.length;j++){
					Object[] paths = fieldPathMap.get(j+1);
					for (int k = 0; paths!=null&&k < paths.length; k++) {
						String path = ((String[])paths[k/3])[k++%3];
						String conversionMethod = ((String[])paths[k/3])[++k%3];

						if (conversionMethod != null) {
							Object converted = theHelper.invokeMethod(theHelper,
									conversionMethod, numberFields[j], String.class);
							if (converted!=null)
								theHelper.setAttributeForPath(customerInformation, "set",path, converted);
						} else {
							theHelper.setAttributeForPath(customerInformation, "set",path, numberFields[j]);
						}
					}
				}
			}
		}
	}

	private String populateTableData(GetFNPCustomerDataDAO dao,
			String servSubsId, String serviceCode,
			CustomerInformation customerInformation,boolean bOpenOrder, FNPInformationHolder infoHolder, BksHelper theHelper) throws Exception {
		ArrayList<HashMap<String,Object>> contract = dao.getContractData(servSubsId);
		String productCode = null;
		if (contract != null && contract.size() > 0) {
			productCode = contract.get(0).get("PRODUCT_CODE").toString();
			if (Arrays.asList(hardwareServices).contains(serviceCode))
				productCode = "-";
			HashMap<String,ArrayList<String[]>> tableMap = null;
			if(bOpenOrder){
				tableMap = BksRefDataCacheHandler.getSidOpenTableColumnMap().get(productCode+";"+serviceCode);
				if (tableMap != null && tableMap.size() > 0)
					infoHolder.setHasRelevantServices(true);
			}else {
				String[] mainServices = {"V0010","V0003","I1209","I1210","V0004","V0002","V0001","V0011","V0012","I1043","I1213","I1290","I121z"};
				if (Arrays.asList(mainServices).contains(serviceCode) ||  infoHolder.changeEndDate()){
					if (Arrays.asList(mainServices).contains(serviceCode))
						infoHolder.setChangeEndDate(false);
					int lastIndex = customerInformation.getProductOfferingSubscription().size() -1;
					CalendarDate signDate = 
						theHelper.convertToDate(contract.get(0).get("PRIMARY_CUST_SIGN_DATE").toString());
					customerInformation.getProductOfferingSubscription().get(lastIndex).setSignDate(signDate);
					setContractEndDate(contract,customerInformation.getProductOfferingSubscription().get(lastIndex), theHelper);
				}
				tableMap = BksRefDataCacheHandler.getSidTableColumnMap().get(productCode+";"+serviceCode);
			}
			if (tableMap == null)
				return productCode;
			Set<String> keys = tableMap.keySet();
			Iterator<String> keyiter = keys.iterator();
			while (keyiter.hasNext()){
				String columnName = keyiter.next();
				if (columnName.equals("-")){
					for (int i = 0; i < tableMap.get(columnName).size(); i++) {
						String path = (String) tableMap.get(columnName).get(i)[0];
						theHelper.setAttributeForPath(customerInformation, "set", path, tableMap.get(columnName).get(i)[1].toString());
					}
					continue;
				}
				for (int i = 0; i < tableMap.get(columnName).size(); i++) {
					if (columnName.equals("CONTRACT_END_DATE")){
						String path = (String) tableMap.get(columnName).get(i)[0];
						Object startDate = contract.get(0).get("MIN_PERIOD_START_DATE");
						String minUnit = (String)contract.get(0).get("MIN_PERIOD_DUR_UNIT_RD");
						Integer minValue = null;
						if (contract.get(0).get("MIN_PERIOD_DUR_VALUE") != null) 
							minValue = ((BigDecimal) contract.get(0).get("MIN_PERIOD_DUR_VALUE")).intValue(); 
						String durationUnit = (String)contract.get(0).get("AUTO_EXTENT_DUR_UNIT_RD");
						Integer extValue = null;
						if (contract.get(0).get("AUTO_EXTENT_DUR_VALUE") != null)
							extValue = ((BigDecimal)contract.get(0).get("AUTO_EXTENT_DUR_VALUE")).intValue();
						boolean bAutoExtend = false;
						if (contract.get(0).get("AUTO_EXTENSION_IND") != null)
							bAutoExtend = ((String)contract.get(0).get("AUTO_EXTENSION_IND")).equals("Y");
						Object converted = 
							theHelper.getContractEndDate(startDate, minUnit, minValue, durationUnit, extValue, bAutoExtend);
						theHelper.setAttributeForPath(customerInformation, "set", path, converted);
					} else {
						String columnValue = null;
						if (contract.get(0).get(columnName)!=null)
							columnValue = contract.get(0).get(columnName).toString();
						else
							break;
						String path = tableMap.get(columnName).get(i)[0];
						String conversionMethod = tableMap.get(columnName).get(i)[1];
						String prefix = tableMap.get(columnName).get(i)[2];
						String introVersion = tableMap.get(columnName).get(i)[4];
						if (introVersion != null && introVersion.compareTo("BKS-005") > 0 )
							continue;
						if (prefix != null)
							columnValue = prefix + columnValue;
						if (conversionMethod != null) {
							Object converted = theHelper.invokeMethod(theHelper,
									conversionMethod, columnValue, String.class);
							theHelper.setAttributeForPath(customerInformation, "set", path, converted);
						} else {
							theHelper.setAttributeForPath(customerInformation, "set", path, columnValue);
						}
					}
				}
			}
		} else {
			throw new Exception("No contract found for service subscription "+servSubsId);
		}
		return productCode;
	}

	private void setContractEndDate(ArrayList<HashMap<String, Object>> contract,
			ProductOfferingSubscription productOfferingSubscription, BksHelper theHelper) {
		Object startDate = contract.get(0).get("MIN_PERIOD_START_DATE");
		String minUnit = (String)contract.get(0).get("MIN_PERIOD_DUR_UNIT_RD");
		Integer minValue = null;
		if (contract.get(0).get("MIN_PERIOD_DUR_VALUE") != null) 
			minValue = ((BigDecimal) contract.get(0).get("MIN_PERIOD_DUR_VALUE")).intValue(); 
		String durationUnit = (String)contract.get(0).get("AUTO_EXTENT_DUR_UNIT_RD");
		Integer extValue = null;
		if (contract.get(0).get("AUTO_EXTENT_DUR_VALUE") != null)
			extValue = ((BigDecimal)contract.get(0).get("AUTO_EXTENT_DUR_VALUE")).intValue();
		boolean bAutoExtend = false;
		if (contract.get(0).get("AUTO_EXTENSION_IND") != null)
			bAutoExtend = ((String)contract.get(0).get("AUTO_EXTENSION_IND")).equals("Y");
		CalendarDate endDate = 
			theHelper.getContractEndDate(startDate, minUnit, minValue, durationUnit, extValue, bAutoExtend);
		productOfferingSubscription.setContractDurationEnd(endDate);
		Integer noticeValue = null;
		if (contract.get(0).get("NOTICE_PERIOD_DUR_VALUE") != null) {
			noticeValue = ((BigDecimal) contract.get(0).get("NOTICE_PERIOD_DUR_VALUE")).intValue(); 
			productOfferingSubscription.setLastNoticeDateToTerminate(endDate.plusMonths(-1*noticeValue));
		}
		ContractStartDate startvalue = new ContractStartDate();
		startvalue.setValue(theHelper.convertSqlDateToCalendar(startDate));
		productOfferingSubscription.setContractStartDate(startvalue );
		MinimumContractDuration value = new MinimumContractDuration();
		value.setValue(BigDecimal.valueOf((minValue>0)?minValue:1));
		productOfferingSubscription.setMinimumContractDuration(value);
		CalendarDate terminationDate = theHelper.convertSqlDateToCalendar(contract.get(0).get("TERMINATION_DATE"));
		if (terminationDate != null && !terminationDate.toString().equals("1901-1-1")) {
			productOfferingSubscription.setTerminationData(new TerminationData());
			productOfferingSubscription.getTerminationData().setTerminationDate(terminationDate);
			productOfferingSubscription.getTerminationData().setTerminationEntryDate(
					theHelper.convertSqlDateToCalendar(contract.get(0).get("NOTICE_PERIOD_START_DATE")));
			productOfferingSubscription.getTerminationData().setTerminationReason(
					(String)contract.get(0).get("TERMINATION_REASON_RD"));
		}
	}

	
	private void populateAddress(GetFNPCustomerDataDAO dao, String addressId,
			String refDataKey, Object customerInformation, BksHelper theHelper) throws Exception {
		HashMap<String,Object[]> colPathMap = 
			BksRefDataCacheHandler.getCcbSidMap().get(refDataKey);

		ArrayList<HashMap<String, Object>> address = dao.getAddressInfo(addressId);
		if (address !=null && address.size() > 0 )
			populateSidNode(colPathMap, address.get(0), customerInformation, theHelper);
	}

	private void populateAccessInfo(GetFNPCustomerDataDAO dao, String accessInfoId,
			String refDataKey, Object customerInformation, BksHelper theHelper) throws Exception {
		HashMap<String,Object[]> colPathMap = 
				BksRefDataCacheHandler.getCcbSidMap().get(refDataKey+";ACCESS_INFORMATION");

		ArrayList<HashMap<String, Object>> accessInfo = dao.getAccessInfo(accessInfoId);
		if (accessInfo !=null && accessInfo.size() > 0){
			populateSidNode(colPathMap, accessInfo.get(0), customerInformation, theHelper);
			String validationId = (String)accessInfo.get(0).get("EMAIL_VALIDATION_ID");
			if (validationId!=null){
				colPathMap = BksRefDataCacheHandler.getCcbSidMap().get(refDataKey+";EMAIL_VALIDATION");
				ArrayList<HashMap<String, Object>> valid = dao.getEmailValidation(validationId);
				if (valid!=null && valid.size()>0)
					populateSidNode(colPathMap,valid.get(0), customerInformation, theHelper);
			}
		}
	}

	private void populateBillingAccount(GetFNPCustomerDataDAO dao,
			HashMap<String, Object> customer, CustomerInformation customerInformation, BksHelper theHelper) throws Exception  {
		String customerNumber = (String) customer.get("CUSTOMER_NUMBER");
		String maskDigits = (String)customer.get("MASKING_DIGITS_RD");
		boolean isItemized = false;
		FNPInformationHolder infoholder = new FNPInformationHolder();
		infoholder.setInvDeliveryType("PAPER");
		BillingAccount ba = new BillingAccount();
		ba.setInvoiceDelivery(new InvoiceDelivery());
		ArrayList<HashMap<String, Object>> docPattern = dao.getDocumentPattern(customerNumber);
		for (int i = 0;docPattern!=null&& i < docPattern.size(); i++) {
			String documentTempl = (String)docPattern.get(i).get("DOCUMENT_TEMPLATE_NAME");
			isItemized = getInvoiceDelivery(documentTempl,infoholder);
		}
		ba.getInvoiceDelivery().setInvoiceDeliveryType(infoholder.getInvDeliveryType());
		if (!isItemized)
			ba.getInvoiceDelivery().setItemizedBill("no");
		else if (isItemized && maskDigits.equals("-1"))
			ba.getInvoiceDelivery().setItemizedBill("complete");
		else
			ba.getInvoiceDelivery().setItemizedBill("shortened");
		HashMap<String,Object[]> colPathMap = 
			BksRefDataCacheHandler.getCcbSidMap().get("ACCOUNT;ACCOUNT");
		customerInformation.getCustomerInformationData().getBillingAccount().add(ba);
		if (docPattern!=null && docPattern.size() > 0)
			populateSidNode(colPathMap, docPattern.get(0), customerInformation, theHelper);
		getAccountInfo(dao,customerNumber,customerInformation, theHelper);
		ArrayList<HashMap<String, Object>> docRec = dao.getDocumentRecipient(customerNumber);
		if (docRec != null && docRec.size() > 0){
			if (docRec.get(0).get("ENTITY_TYPE").toString().equals("I"))
				colPathMap = 
					BksRefDataCacheHandler.getCcbSidMap().get("ACCOUNT;INDIVIDUAL");
			else
				colPathMap = 
					BksRefDataCacheHandler.getCcbSidMap().get("ACCOUNT;ORGANIZATION");

			populateSidNode(colPathMap, docRec.get(0), customerInformation, theHelper);

			String addressId = (String) docRec.get(0).get("ADDRESS_ID");
			String refDataKey = "ACCOUNT;ADDRESS";
			if (addressId!= null)
				populateAddress(dao,addressId,refDataKey,customerInformation, theHelper);
			String accInfoId = (String) docRec.get(0).get("ACCESS_INFORMATION_ID");
			if (accInfoId != null)
				populateAccessInfo(dao,accInfoId,"ACCOUNT",customerInformation, theHelper);
		}
		List<BillingAccount> account = customerInformation.getCustomerInformationData().getBillingAccount();
		for (int i = 0; i < account.size(); i++) {
			MethodOfPayment mop = account.get(i).getMethodOfPayment();
			if (mop!=null){
				Mandate mandate = mop.getMandate();
				if (mandate!=null&&(mandate.isRecurrentIndicator()==null ||	mandate.getSignatureDate()==null))
					mop.setMandate(null);
			}
		}
	}

	private void getAccountInfo(GetFNPCustomerDataDAO dao,
			String customerNumber, CustomerInformation customerInformation, BksHelper theHelper) throws Exception {
			ArrayList<HashMap<String, Object>> accountData = dao.getAccountData(customerNumber);
			if (accountData==null || accountData.size() < 1){
				String errorText = "Customer has no active billing account.";
				String errorCode = "BKSCOM-ERROR-000025";
				throw new BksDataException(errorCode,errorText);
			}
			if (accountData!=null && accountData.size() > 1){
				String errorText = "Customer with more than one billing account.";
				String errorCode = "BKSCOM-ERROR-000025";
				throw new BksDataException(errorCode,errorText);
			}
			if (accountData!=null && accountData.size() > 0){
				HashMap<String,Object[]> colPathMap = BksRefDataCacheHandler.getCcbSidMap().get("ACCOUNT;ACCOUNT");
				theHelper.setDesiredNewElement(1);
				populateSidNode(colPathMap,accountData.get(0),customerInformation, theHelper);
				String bankAccId = (String)accountData.get(0).get("BANK_ACCOUNT_ID");
				if (bankAccId != null){
					ArrayList<HashMap<String, Object>> bankData = dao.getBankData(bankAccId,customerNumber);
					if (bankData!=null && bankData.size() > 0)
						populateSidNode(colPathMap,bankData.get(0),customerInformation, theHelper);
					BillingAccount accNode = customerInformation.getCustomerInformationData().getBillingAccount().get(0);
					SepaBankAccount sepaNode = accNode.getMethodOfPayment().getSepaBankAccount();
					if (sepaNode!=null && (sepaNode.getIban()== null || sepaNode.getBic()== null ))
						accNode.getMethodOfPayment().setSepaBankAccount(null);
					BankAccount bankNode = accNode.getMethodOfPayment().getBankAccount();
					if (bankNode!=null && (bankNode.getBankAccountNumber()== null||bankNode.getBankCode()== null ))
						accNode.getMethodOfPayment().setBankAccount(null);
				}
			}
	}

	private boolean getInvoiceDelivery(String documentTempl,FNPInformationHolder infoholder) {
        boolean isItemized = false;
        if (documentTempl.equals("webBill mit EGN")){
        	infoholder.setInvDeliveryType("WEBBILL");
        	isItemized=true;
        } else if (documentTempl.equals("webBill ohne EGN")){
        	infoholder.setInvDeliveryType("WEBBILL");
        } else if (documentTempl.equals("Vodafone webBill mit EGN")){
        	infoholder.setInvDeliveryType("WEBBILL");
        	isItemized=true;
        } else if (documentTempl.equals("Vodafone webBill ohne EGN")){
        	infoholder.setInvDeliveryType("WEBBILL");
        } else if (documentTempl.equals("Rechnung per E-Mail")){
        	infoholder.setInvDeliveryType("EMAIL");
        } else if (documentTempl.equals("Privatkunden EVN")){
        	isItemized=true;
        }
 		return isItemized;
	}

	private void populateCustomerData(HashMap<String, Object> custList, CustomerInformation customerInformation, FNPInformationHolder infoHolder, BksHelper theHelper) throws Exception {
			HashMap<String,Object[]> colPathMap = 
				BksRefDataCacheHandler.getCcbSidMap().get("CUSTOMER;CUSTOMER");

			theHelper.setDesiredNewElement(-1);
			populateSidNode(colPathMap, custList, customerInformation, theHelper);
			boolean isIndividual = custList.get("ENTITY_TYPE").toString().equals("I");
			if (isIndividual)
				colPathMap = BksRefDataCacheHandler.getCcbSidMap().get("CUSTOMER;INDIVIDUAL");
			else
				colPathMap = BksRefDataCacheHandler.getCcbSidMap().get("CUSTOMER;ORGANIZATION");
			populateSidNode(colPathMap, custList, customerInformation, theHelper);
			customerInformation.getCustomerInformationStatus().getCustomerType().get(0).setCategory(infoHolder.getCategory());
	}

	private void populateSidNode(HashMap<String, Object[]> colPathMap, 
			HashMap<String,Object> ccbData, Object customerInformation, BksHelper theHelper) throws Exception {
		if (colPathMap == null)
			return;
		Set<String> keys = colPathMap.keySet();
		Iterator<String> keyiter = keys.iterator();
		while (keyiter.hasNext()){
			String column = keyiter.next();
			int index = 0;
			if (column.equals("-")){
				String path = (String) colPathMap.get(column)[0];
				theHelper.setAttributeForPath(customerInformation, "set", path, 
						colPathMap.get(column)[1].toString());
			} else if (column.equals("PROVIDER_CODE")){
				String path = (String) colPathMap.get(column)[0];
				String classification = (String)ccbData.get("CLASSIFICATION_RD");
				String rootCustomer = (String)ccbData.get("ROOT_CUSTOMER_NUMBER");
				String converted = theHelper.mapClassificationToProvider(classification,rootCustomer);
				theHelper.setAttributeForPath(customerInformation, "set", path, 
						converted);
			} else if (column.equals("STREET_NUMBER")){
				String path = (String) colPathMap.get(column)[0];
				String streetNumber = (String)ccbData.get(column);
				if (streetNumber!=null) {
					theHelper.setAttributeForPath(customerInformation, "set", path, getPartValue(streetNumber, 1));
					path = (String) colPathMap.get("STREET_NUMBER_SUFFIX")[0];
					theHelper.setAttributeForPath(customerInformation, "set", path, getPartValue(streetNumber, 2));
				}
			} else if (column.equals("VALIDATION_DATE")){
				String path = (String) colPathMap.get(column)[0];
				String applyMethod = (String) colPathMap.get(column)[1];
				Timestamp value = (Timestamp)ccbData.get(column);
				String status = (String)ccbData.get("VALIDATION_STATUS");
				if (Arrays.asList(validStatus).contains(status)){
					Object converted = theHelper.invokeMethod(theHelper,applyMethod, value.toString().trim(), String.class);
					theHelper.setAttributeForPath(customerInformation, "set", path, converted);
				}
			} else if (column.equals("ERROR_CODE")){
				String path = (String) colPathMap.get(column)[0];
				String value = (String)ccbData.get(column);
				String status = (String)ccbData.get("VALIDATION_STATUS");
				if (status.equals("IN_PROGRESS")||status.equals("FAILED"))
					theHelper.setAttributeForPath(customerInformation, "set", path, value);
			} else {
				while (index < colPathMap.get(column).length) {
					String path = (String) colPathMap.get(column)[index++];
					String convertMethod = (String) colPathMap.get(column)[index++];
					String defaultValue = (String) colPathMap.get(column)[index++];
					String fldNumStr = (String) colPathMap.get(column)[index++];
					String introVersion = (String) colPathMap.get(column)[index++];
					if (introVersion != null && introVersion.compareTo("BKS-005") > 0 )
						continue;
					
					Object value = ccbData.get(column);
					if (value != null) {
						if (convertMethod == null)
							theHelper.setAttributeForPath(customerInformation, "set", path, value);
						else {
							Object converted = theHelper.invokeMethod(theHelper,
									convertMethod, value.toString(), String.class);
							if (converted==null)
								converted=defaultValue;
							if (converted!=null)
								theHelper.setAttributeForPath(customerInformation, "set", path,converted);
						}
					}
				}
			}
		}

	}
	ArrayList<HashMap<String, Object>> getCustomerList(GetFNPCustomerDataDAO dao,GetFNPCustomerDataRequest request, FNPInformationHolder infoHolder, String requestType, BksHelper theHelper) throws Exception{
		ArrayList<HashMap<String, Object>> custList = null;
		String barcode = request.getBarcode();
		String bundleId = request.getSerialNumber();
		PersonDataQueryInput person = request.getPersonData();
		CompanyDataQueryInput company = request.getCompanyData();
		ComplexPhoneNumber accnum = request.getAccessNumber();
		if (accnum != null) {
			custList = getCustomerByAccessNumber(dao,accnum, infoHolder);
			if (custList!=null && custList.size() > 1){
				String errorText = "Found access number more than one time.";
				String errorCode = "BKSCOM-ERROR-000007";
				throw new BksDataException(errorCode,errorText);
			}
			if (custList!=null && custList.size() > 0) {
				String accnumString = (String)custList.get(0).get("ACCESS_NUMBER");
				if (!validateAccnumFormat(accnumString,accnum)) {
					String errorText = "No customer found";
					String errorCode = "BKSCOM-ERROR-000002";
					throw new BksDataException(errorCode,errorText);
				}

				String custNo = (String) custList.get(0).get("CUSTOMER_NUMBER");
				Object bd = custList.get(0).get("BIRTH_DATE");
				String encryptedpw = (String) custList.get(0).get("USER_PASSWORD");
				String encryptKey = (String) custList.get(0).get("ENCRYPTION_KEY");
				theHelper.setCustomerEncKey(encryptKey);
				String password = theHelper.decryptCustPasswd(encryptedpw);
				
				if (request.getCustomerNumber() != null && !request.getCustomerNumber().equals(custNo)){
					String errorText = "customer number on access number found does not match customer number provided";
					String errorCode = "BKSCOM-ERROR-000003";
					throw new BksDataException(errorCode,errorText);
				}
				CalendarDate dateOfBirth = null;
				String inputPw = null;
				if (person != null) {
					dateOfBirth = person.getDateOfBirth();
					inputPw = person.getUserPassword();
				}
				if (request.getRequestType().equals("CPD")&& 
					!additionalDataProvided(request.getCustomerNumber(),inputPw,dateOfBirth)){
					String errorText = "Missing mandatory additional information. At least phone number and birthDate or two out of the list of obligate parameters have to be provided [customerNumber,birthDate,userPasswort].";
					String errorCode = "BKSCOM-ERROR-000006";
					throw new BksDataException(errorCode,errorText);
				}
				if (dateOfBirth != null && bd != null && !dateOfBirth.equals(CalendarDate.from(bd.toString(), "yyyy-MM-dd"))){
					String errorText = "Provided birth date does not match";
					String errorCode = "BKSCOM-ERROR-000005";
					throw new BksDataException(errorCode,errorText);
				}			
				if (inputPw != null && !inputPw.equalsIgnoreCase(password)){
					String errorText = "Wrong password";
					String errorCode = "BKSCOM-ERROR-000004";
					throw new BksDataException(errorCode,errorText);
				}
			}
		}else if (request.getCustomerNumber() != null) {
			custList = dao.getCustomerForCustNumber(request.getCustomerNumber());
			if (custList != null && custList.size() > 0){
				if (custList.get(0).get("ENTITY_TYPE").toString().equals("I"))
					infoHolder.setCategory("RESIDENTIAL");
				else
					infoHolder.setCategory("BUSINESS");
			}
		}else if (barcode != null) {
			custList = dao.getExternalOrderByBarcode(barcode);
			if (custList==null || custList.size()==0)
				custList = dao.getCustomerForBarCode(barcode);
			if (custList != null && custList.size() > 0){
				if (custList.get(0).get("ENTITY_TYPE").toString().equals("I"))
					infoHolder.setCategory("RESIDENTIAL");
				else
					infoHolder.setCategory("BUSINESS");
			}
		}else if (bundleId != null) {
			custList = dao.getCustomerForBundleId(bundleId);
			if (custList != null && custList.size() > 0){
				if (custList.get(0).get("ENTITY_TYPE").toString().equals("I"))
					infoHolder.setCategory("RESIDENTIAL");
				else
					infoHolder.setCategory("BUSINESS");
			}
		}else if (person != null) {
			if (request.getRequestType().equals("CPD")){
				String errorText = "The input parameter (person data) does not match request type CPD.";
				String errorCode = "BKSCOM-ERROR-000008";
				throw new BksDataException(errorCode,errorText);
			}
			custList = getCustomerByPersonData(dao,person, infoHolder, requestType);
		}else if (company != null){
			if (request.getRequestType().equals("CPD")){
				String errorText = "The input parameter (company data) does not match request type CPD.";
				String errorCode = "BKSCOM-ERROR-000008";
				throw new BksDataException(errorCode,errorText);
			}
			custList = getCustomerByCompanyData(dao,company, infoHolder,requestType);
		}else {
			String errorText = "Wrong input setting";
			String errorCode = "BKSCOM-ERROR-000002";
			throw new BksDataException(errorCode,errorText);
		}  

		if ((custList == null) || (custList.size() < 1)) {
			String errorText = "No customer found";
			String errorCode = "BKSCOM-ERROR-000002";
			throw new BksDataException(errorCode,errorText);
		}
		
		ArrayList<String> custNumberList = new ArrayList<String>();
		for (int i = 0; i < custList.size(); i++) {
			String custNum = (String) custList.get(i).get("CUSTOMER_NUMBER");
			if (custNumberList.contains(custNum)){
				custList.remove(i);
				i--;
				continue;
			} else
				custNumberList.add(custNum);
			
			String classification = (String) custList.get(i).get("CLASSIFICATION_RD");
			if (classification.startsWith("R") || classification.startsWith("Q")) {
					if (custList.size()==1){
						String errorText = "Non supported customer classification";
						String errorCode = "BKSCOM-ERROR-000022";
						throw new BksDataException(errorCode,errorText);
					} else {
						custList.remove(i);
						i--;
						continue;
					}
				}
			if (barcode == null	&& (classification.startsWith("A") || 
				classification.startsWith("B"))) {
				if (custList.size()==1){
					String errorText = "Non supported customer classification";
					String errorCode = "BKSCOM-ERROR-000022";
					throw new BksDataException(errorCode,errorText);
				} else {
					custList.remove(i);
					i--;
					continue;
				}
			}
			String group = (String) custList.get(i).get("CUSTOMER_GROUP_RD");
			/* Increment the criteria for filtering the customer group for Project ID: 188429_256581 */
			if (!group.equals("03") && !group.equals("81")
					&& !group.equals("84") && !group.equals("12") && !group.equals("20") && !group.equals("21") && !group.equals("83") && !group.equals("80")) {
				if (custList.size()==1){
					String errorText = "No customer found";
					String errorCode = "BKSCOM-ERROR-000002";
					throw new BksDataException(errorCode,errorText);
				} else {
					custList.remove(i);
					i--;
					continue;
				}
			}
			String parentCustomer = (String) custList.get(i).get(
					"ASSOCIATED_CUSTOMER_NUMBER");
			if (parentCustomer != null) {
				if (custList.size()==1){
					String errorText = "Customer of a hierarchy";
					String errorCode = "BKSCOM-ERROR-000024";
					throw new BksDataException(errorCode,errorText);
				} else {
					custList.remove(i);
					i--;
					continue;
				}
			}
			if (doesCustomerOwnSDC(dao,custNum)){
				if (custList.size()==1){
					String errorText = "Customer owns service delivery contract.";
					String errorCode = "BKSCOM-ERROR-000027";
					throw new BksDataException(errorCode,errorText);
				} else {
					custList.remove(i);
					i--;
					continue;
				}
			}
		}

		if ((custList == null) || (custList.size() < 1)) {
			String errorText = "No customer found";
			String errorCode = "BKSCOM-ERROR-000002";
			throw new BksDataException(errorCode,errorText);
		}
		
		return custList;
	}

	private boolean validateAccnumFormat(String accnumString,
			ComplexPhoneNumber accnum) {
		String countryCode = accnum.getCountryCode();
		String cityCode = accnum.getLocalAreaCode();
		String[] splittedAcc = accnumString.split(";");
		if (splittedAcc.length > 1 && splittedAcc[0].equals(countryCode)&&
			splittedAcc[1].equals(cityCode))
			return true;
		return false;
	}

	private boolean doesCustomerOwnSDC(GetFNPCustomerDataDAO dao, String custNum) throws Exception {
		ArrayList<HashMap<String, Object>> contcust = null;
		contcust = dao.getCustomerSDC(custNum);
		if (contcust != null && contcust.size() > 0)
			return true;
		return false;
	}

	private boolean additionalDataProvided(String customerNumber,
			String password, CalendarDate dateOfBirth) {
		if (dateOfBirth!=null)
			return true;
		else			
			return (password!=null && customerNumber!=null);
	}

	private ArrayList<HashMap<String, Object>> getCustomerByAccessNumber(
			GetFNPCustomerDataDAO dao, ComplexPhoneNumber accnum, FNPInformationHolder infoHolder) throws Exception {
		ArrayList<HashMap<String, Object>> custList = null;
		String countryCode = accnum.getCountryCode();
		String cityCode = accnum.getLocalAreaCode();
		String localNumber = accnum.getPhoneNumbers().getPhoneNumber().get(0);
		custList = dao.getCustomerExactAccessNumberCustData(
				countryCode, cityCode, localNumber);
		if (custList == null || custList.size() == 0) {
			custList = dao.getCustomerAccessNumberCustData(countryCode,
					cityCode, localNumber);
		}
		if (custList != null && custList.size() > 0){
			if (custList.get(0).get("ENTITY_TYPE").toString().equals("I"))
				infoHolder.setCategory("RESIDENTIAL");
			else
				infoHolder.setCategory("BUSINESS");
		}
		ArrayList<String> custNumList= new ArrayList<String>();
		for (int i=0;custList != null&&i<custList.size();i++){
			String custNum = (String)custList.get(0).get("CUSTOMER_NUMBER");
			if (custNumList.contains(custNum)){
				custList.remove(i);
				i--;
				continue;
			}
			custNumList.add(custNum);
		}
		return custList;
	}

	private ArrayList<HashMap<String, Object>> getCustomerByCompanyData(
			GetFNPCustomerDataDAO dao, CompanyDataQueryInput company, FNPInformationHolder infoHolder, String requestType) throws Exception {
		ArrayList<HashMap<String, Object>> custList = null;
		String name = company.getCompanyName();
		String zipCode = company.getZipCode();
		String street = company.getStreet();
		String streetNo = company.getHousenumber();
		String streetNoSuf = company.getHousenumberSuffix();
		String orgSuf = company.getCompanySuffixName();
		String regNo = company.getCommercialRegisterNumber();
		String phonName = (new FudickarPhoneticConverter()).convert(name);
		String phonOrgSuffix = null;
		if (orgSuf != null) 
			phonOrgSuffix = (new FudickarPhoneticConverter()).convert(orgSuf);
		
		CalendarDate dateOfBirth = null;
		if (company.getContact() != null)
			dateOfBirth = company.getContact().getDateOfBirth();

		if (name != null) {
			boolean bFuzzySearch = Boolean.parseBoolean(DatabaseClientConfig.getSetting("databaseclient.EnableFuzzySearch"));
			try {
				if (bFuzzySearch && dao.getDataSourceName().equals("effonl") &&
					(requestType.equals("ICP") || requestType.equals("CID")))
					custList = dao.getCustomerFuzzyCompany(phonName, phonOrgSuffix, zipCode,
							street, streetNo,streetNoSuf,regNo);
				else
					custList = dao.getCustomerCompanyData(name, zipCode,
						street, streetNo,streetNoSuf,orgSuf,regNo);
			} catch (UncategorizedSQLException e) {
				if (e.getSQLException().getErrorCode() == 1013){
					String errorCode = "BKSCOM-ERROR-000008";
					String errorText = "Query Timed out.";
					throw new BksDataException(errorCode,errorText);
				}
				throw e;
			}
		}
		if (custList!= null && custList.size() > 0) {
			if (dateOfBirth != null){
				String customerNo = custList.get(0).get("CUSTOMER_NUMBER").toString();
				ArrayList<HashMap<String, Object>> contacts = dao.getOwnerContact(customerNo);
				if (contacts!= null && contacts.size() > 0 ){
					for (int i = 0; i < custList.size(); i++) {
						Object bd = contacts.get(i).get("BIRTH_DATE");
						if (bd != null && !dateOfBirth.equals(CalendarDate.from(bd.toString(), "yyyy-MM-dd"))) {
							if (custList.size() == 1) {
								String errorText = "Provided birth date does not match";
								String errorCode = "BKSCOM-ERROR-000005";
								throw new BksDataException(errorCode,errorText);
							} else {
								custList.remove(i);
								i--;
								continue;
							}
						}
					}
				}
				infoHolder.setCategory("SOHO");
			} else if (regNo != null) {
				infoHolder.setCategory("BUSINESS");
				for (int i = 0; i < custList.size(); i++) {
					String register = (String) custList.get(i).get("INCORPORATION_NUMBER_ID");
					if (!regNo.equals(register)) {
						if (custList.size() == 1) {
							String errorText = "Provided registration number does not match";
							String errorCode = "BKSCOM-ERROR-000005";
							throw new BksDataException(errorCode,errorText);
						} else {
							custList.remove(i);
							i--;
							continue;
						}
					}
				}
			} else {
				infoHolder.setCategory("BUSINESS");
				String corpType = (String)custList.get(0).get("INCORPORATION_TYPE_RD");
				if (corpType != null && !corpType.equals("UNREGISTERED") && !corpType.equals("NOT")
						&& !requestType.equals("ICP") && !requestType.equals("CID")){
					String errorText = "For corp. type "+corpType+" registration number must be provided.";
					String errorCode = "BKSCOM-ERROR-000005";
					throw new BksDataException(errorCode,errorText);
				}
			}
		}
		return custList;
	}

	private ArrayList<HashMap<String, Object>> getCustomerByPersonData(
			GetFNPCustomerDataDAO dao, PersonDataQueryInput person, 
			FNPInformationHolder infoHolder, String requestType) throws Exception {
		ArrayList<HashMap<String, Object>> custList = null;
		String familyName = person.getFamilyName();
		String zipCode = person.getZipCode();
		String street = person.getStreet();
		String streetNo = person.getHousenumber();
		String streetNoSuf = person.getHousenumberSuffix();
		String firstName = person.getFirstName();
		String phonName = (new FudickarPhoneticConverter()).convert(familyName);
		String phonFirstName = null;
		if (firstName != null) 
			phonFirstName = (new FudickarPhoneticConverter()).convert(firstName);
		
		CalendarDate dateOfBirth = person.getDateOfBirth();
		infoHolder.setCategory("RESIDENTIAL");

		if (familyName == null) {
			String errorText = "Missing mandatory input (family name).";
			String errorCode = "BKSCOM-ERROR-000008";
			throw new BksDataException(errorCode,errorText);
		} else if (street == null && !requestType.equals("ICP") && !requestType.equals("CID")) {
			String errorText = "Missing mandatory input (street name).";
			String errorCode = "BKSCOM-ERROR-000008";
			throw new BksDataException(errorCode,errorText);
		} else {
			if (familyName != null)
				familyName = familyName.replaceAll( "\\*", "%");
			if (street != null)
				street = street.replaceAll( "\\*", "%");
		}
		if (familyName != null) {
			boolean bFuzzySearch = Boolean.parseBoolean(DatabaseClientConfig.getSetting("databaseclient.EnableFuzzySearch"));
			try {
				if (bFuzzySearch && dao.getDataSourceName().equals("effonl") &&
				   (requestType.equals("ICP") || requestType.equals("CID")))
					custList = dao.getCustomerFuzzyPerson(phonFirstName, phonName, 
							zipCode, street,streetNo,streetNoSuf, dateOfBirth);
				else
					custList = dao.getCustomerPersonData(familyName, zipCode,
						street,streetNo,streetNoSuf, firstName, dateOfBirth);
			} catch (UncategorizedSQLException e) {
				if (e.getSQLException().getErrorCode() == 1013){
					String errorCode = "BKSCOM-ERROR-000008";
					String errorText = "Query Timed out.";
					throw new BksDataException(errorCode,errorText);
				}
				throw e;
			}
		}
		return custList;
	}

	private boolean doesCustomerParse(CustomerInformation customerInformation) {
		GetFNPCustomerDataResponse tmpOut = new GetFNPCustomerDataResponse();
		tmpOut.setSidcomVersion("1.0");
		tmpOut.getSid().add(customerInformation);
		try {
			ExperimentalXmlProcessor xmlProc = ExperimentalXmlProcessor
					.getInstance();
			xmlProc.serialize(tmpOut, "schema/BKS-005.xsd",
					"de.vodafone.esb.service.sbus.bks.bks_005");
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	private void populateLogTable(String errorCode, String errorText, String customerNumber, 
			String correlationId, String serviceName, String accessNumber, long startTime,
			long endTime, boolean cacheHit,GetFNPCustomerDataRequest request) {
	    boolean loggingEnabled = false;
	    try {
			String tmp = DatabaseClientConfig.getSetting("databaseclient.EnableDbLogging");
			loggingEnabled = (tmp.equalsIgnoreCase("true"));
		} catch (Exception e) {
			// ignore
		}
		if (loggingEnabled) {
			GeneralDAO dao = null;
			try {
				dao = (GeneralDAO)DatabaseClient.getBksDaoForTargetDb("onl","GeneralDAO");
			} catch (Exception e) {
			}
			if (dao != null) {
				dao.insertLog(errorCode, errorText,(errorCode == null) ? "SUCCESS":"FAILED", 
						customerNumber, accessNumber,correlationId, serviceName, 
						cacheHit ? "Y" : "N",new Timestamp(startTime), new Timestamp(endTime));
				if (errorText != null || errorCode != null) {
					try {
						populateErrorLogParams(dao, correlationId,serviceName, request);
					} catch (Exception e) {
					}
				}
			}
			try {
				dao = null;
				dao = (GeneralDAO)DatabaseClient.getBksDaoForTargetDb("effonl","GeneralDAO");
			} catch (Exception e) {
			}
			if (dao != null) {
				dao.insertLog(errorCode, errorText,(errorCode == null) ? "SUCCESS":"FAILED", 
						customerNumber, accessNumber,
						correlationId, serviceName, cacheHit ? "Y" : "N",
						new Timestamp(startTime), new Timestamp(endTime));
				if (errorText != null|| errorCode != null) {
					try {
						populateErrorLogParams(dao, correlationId,serviceName, request);
					} catch (Exception e) {
					}
				}
			}
		}
	}

	private void populateErrorLogParams(GeneralDAO dao,String correlationId, String serviceName,
			GetFNPCustomerDataRequest indata) throws Exception {
		Method[] methods = indata.getClass().getMethods();
		Method theMethod = null;
		Integer seqNum = 0;
		// find the right method
		for (int i=0;i<methods.length;i++) {
			if (methods[i].getName().startsWith("get")){
				theMethod = methods[i];
				Object value = theMethod.invoke(indata, (Object[]) null);
				if (value != null){
					String name = theMethod.getName().substring(3);
					try {
						Method m = value.getClass().getMethod("getExisting");
						value = m.invoke(value, (Object[])null);
					} catch (NoSuchMethodException  e) {
						// Ignore
					}
					if (value instanceof ComplexPhoneNumber){
						String strValue = ((ComplexPhoneNumber)value).getCountryCode()+ " " +
						((ComplexPhoneNumber)value).getLocalAreaCode() + "/" +
						((ComplexPhoneNumber)value).getPhoneNumbers().getPhoneNumber().get(0);
						dao.createErrorLogParam(correlationId,name, strValue,null,seqNum++);
					} else if (value instanceof PersonDataQueryInput){
						String strValue = ((PersonDataQueryInput)value).getFamilyName();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"FamilyName", strValue,null,seqNum++);
						strValue = ((PersonDataQueryInput)value).getZipCode();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"ZipCode", strValue,null,seqNum++);
						strValue = ((PersonDataQueryInput)value).getStreet();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"Street", strValue,null,seqNum++);
						strValue = ((PersonDataQueryInput)value).getHousenumber();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"Housenumber", strValue,null,seqNum++);
						strValue = ((PersonDataQueryInput)value).getHousenumberSuffix();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"HousenumberSuffix", strValue,null,seqNum++);
						strValue = ((PersonDataQueryInput)value).getFirstName();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"FirstName", strValue,null,seqNum++);
						CalendarDate dateOfBirth = ((PersonDataQueryInput)value).getDateOfBirth();
						if (dateOfBirth!=null)
							dao.createErrorLogParam(correlationId,"DateOfBirth", dateOfBirth.toString(),null,seqNum++);
					} else if (value instanceof CompanyDataQueryInput){
						String strValue = ((CompanyDataQueryInput)value).getCompanyName();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"CompanyName", strValue,null,seqNum++);
						strValue = ((CompanyDataQueryInput)value).getZipCode();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"ZipCode", strValue,null,seqNum++);
						strValue = ((CompanyDataQueryInput)value).getStreet();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"Street", strValue,null,seqNum++);
						strValue = ((CompanyDataQueryInput)value).getHousenumber();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"Housenumber", strValue,null,seqNum++);
						strValue = ((CompanyDataQueryInput)value).getHousenumberSuffix();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"HousenumberSuffix", strValue,null,seqNum++);
						strValue = ((CompanyDataQueryInput)value).getCompanySuffixName();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"CompanySuffixName", strValue,null,seqNum++);
						strValue = ((CompanyDataQueryInput)value).getCommercialRegisterNumber();
						if (strValue!=null)
							dao.createErrorLogParam(correlationId,"CommercialRegisterNumber", strValue,null,seqNum++);
						CalendarDate dateOfBirth = ((CompanyDataQueryInput)value).getContact().getDateOfBirth();
						if (dateOfBirth!=null)
							dao.createErrorLogParam(correlationId,"DateOfBirth", dateOfBirth.toString(),null,seqNum++);
					} else	if (value.getClass().isPrimitive())
						dao.createErrorLogParam(correlationId,name, value.toString(),null,seqNum++);
				}
			}
		}
	}
}
