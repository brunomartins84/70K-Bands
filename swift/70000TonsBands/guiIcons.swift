//
//  guiIcons.swift
//  70000TonsBands
//
//  Created by Ron Dorn on 1/13/15.
//  Copyright (c) 2015 Ron Dorn. All rights reserved.
//

import Foundation
import UIKit

let mustSeeIcon = "icon-going-yes"
let mightSeeIcon = "icon-going-maybe"
let wontSeeIcon = "icon-going-no"
let unknownIcon = "icon-going-unknown"

let mustSeeIconAlt = "icon-going-yes-alt"
let mightSeeIconAlt = "icon-going-maybe-alt"
let wontSeeIconAlt = "icon-going-no-alt"
let unknownIconAlt = "icon-going-unknown-alt"

let scheduleIconSort = "icon-sort-time-decending"
let bandIconSort = "icon-sort-az-decending"

let showTypeIcon = "";
let specialEventTypeIcon = "specialEvent";
let mAndmEventTypeIcon = "specialEvent";
let listeningEventTypeIcon = "specialEvent";
let clinicEventTypeIcon = "specialEvent";
let unofficalEventTypeIcon = "specialEvent";

//shows attended
let sawAllIcon = "icon-seen"
let sawSomeIcon = "icon-seen-partial"
let sawNoneIcon = ""
let attendedShowIcon = "icon-seen"
let attendedShowIconAlt = "icon-seen-alt"

let poolVenue = "🏊"
let theaterVenue = "🎭"
let loungeVenue = "🎤"
let rinkVenue = "⛸"
let unknownVenue = "❓"

func getEventTypeIcon (_ eventType: String)->UIImage {
    
    var graphicName = String()
    var graphicImage = UIImage()
    
    switch eventType {
    case showType:
        graphicName = showTypeIcon
        
    case meetAndGreetype:
        graphicName = mAndmEventTypeIcon
        
    case specialEventType:
        graphicName = specialEventTypeIcon
        
    case clinicType:
        graphicName = clinicEventTypeIcon

    case listeningPartyType:
        graphicName = listeningEventTypeIcon
    
    case unofficalEventType:
        graphicName = unofficalEventTypeIcon

    case unofficalEventTypeOld:
        graphicName = unofficalEventTypeIcon
        
    default:
        graphicName = unknownVenue
    }
    
    graphicImage = UIImage(named: graphicName) ?? UIImage()
    
    return graphicImage
    
}

func getSortButtonImage()->UIImage{
    
    var sortImage:UIImage
    
    print ("scheduleIcon = \(getSortedBy())")
    if (getSortedBy() == "name"){
        sortImage = UIImage(named: scheduleIconSort) ?? UIImage()
        
    } else {
        sortImage = UIImage(named: bandIconSort) ?? UIImage()
    }
    
    return sortImage
}

func getRankGuiIcons (rank: String)->UIImage {
   
    var graphicName = String()
    var graphicImage = UIImage()
    
    switch rank {
    case "must":
        graphicName = mustSeeIcon

    case "might":
        graphicName = mightSeeIcon

    case "wont":
        graphicName = wontSeeIcon

    case "unknown":
        graphicName = unknownIcon
        
    case "mustAlt":
        graphicName = mustSeeIconAlt
        
    case "mightAlt":
        graphicName = mightSeeIconAlt
        
    case "wontAlt":
        graphicName = wontSeeIconAlt

    case "unknownAlt":
        graphicName = unknownIconAlt
        
    default:
        graphicName = ""
    }
    
    graphicImage = UIImage(named: graphicName) ?? UIImage()
    
    return graphicImage
    
}

func getVenuIcon(_ venue: String)->String {
    
    switch venue {
        case "Pool":
            return poolVenue

        case "Theater":
            return theaterVenue

        case "Lounge":
            return loungeVenue
        
        case "Rink":
            return rinkVenue

        default:
            //exit(1);
            return ""
    }
}

func getPriorityIcon(_ index: Int) -> String {

    switch index {
    case 1:
        return mustSeeIcon
        
    case 2:
        return mightSeeIcon
        
    case 3:
        return wontSeeIcon
        
    default:
        return ""
    }
}

func getPriorityGraphic(_ index: Int) -> String {

    switch index {
    case 1:
        return "icon-going-yes"
        
    case 2:
        return "icon-going-maybe"
        
    case 3:
        return "icon-going-no"
        
    default:
        return ""
    }
}

func getBandIconSort() -> String {
   return bandIconSort
}

func getScheduleIcon() -> String {
    
    if (getSortedBy() == "name"){
        return scheduleIconSort
    
    } else {
        
      return bandIconSort
        
    }
}

func getPoolIcon() -> String {
    return poolVenue
}

func getTheaterIcon() -> String {
    return theaterVenue
}

func getLoungeIcon() -> String {
    return loungeVenue
}

func getRinkIcon() -> String {
    return rinkVenue
}

func getUnknownVenueIcon() -> String {
    return unknownVenue
}

func getMustSeeIcon () -> String {
    return mustSeeIcon
}

func getMightSeeIcon  () -> String {
    return mightSeeIcon
}

func getWillNotSeeIcon  () -> String {
    return wontSeeIcon
}

func getUnknownIcon() -> String {
    return unknownIcon
}

func getPoolVenueIcon() -> String {
    return poolVenue
}

func gettheaterVenueIcon() -> String {
    return theaterVenue
}

func getloungeVenueIcon() -> String {
    return loungeVenue
}

func getrinkVenueIcon() -> String {
    return rinkVenue
}

func getunknownVenueIcon() -> String {
    return unknownVenue
}
