
// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;


contract FoodTracker {

    enum EventStatus{ FORMER_REQ, SUPPLIER_COLLECTED, MANF_RECEIVED, MANF_QLTY_CHECK, 
            MANF_CLEANED, MANF_PROCESSED, DISPATCHED, RETAIL_RECEIVED}

    struct ServiceRequestEventHistory {
        uint256 eventDate;
        uint weight;
        EventStatus status;
    }

    struct ServiceRequest {
        uint serviceRequestId;
        string batchId;
        string referenceId;
        string packageId;
        EventStatus status;
        ServiceRequestEventHistory[] events;
    }

    uint public idTracker = 1;

    ServiceRequest[] public serviceRequestArray;

    mapping(string => uint) public batchIdServiceRequestIndexId;

    function getId() public returns (uint) {
        return idTracker++;
    }

    function findServiceRequestIndexId(string memory batchId) public view returns (uint) {
        return batchIdServiceRequestIndexId[batchId];
    }

    function createServiceRequest(string memory batchId, string memory reference_id, string memory packageId, uint weight, EventStatus status) public 
    {
    
        ServiceRequestEventHistory memory eventHistory = ServiceRequestEventHistory({
            eventDate: block.timestamp,
            weight: weight,
            status: status
        });

        uint serviceRequestIndex = findServiceRequestIndexId(batchId);
        ServiceRequest storage serviceRequest;
        if (serviceRequestIndex > 0) {
              serviceRequest = serviceRequestArray[serviceRequestIndex];
        } else {
              serviceRequest = serviceRequestArray.push();
        }
        serviceRequest.batchId = batchId;
        serviceRequest.referenceId = reference_id;
        serviceRequest.packageId = packageId;
        serviceRequest.status = status;
        serviceRequest.events.push(eventHistory);
    }

}