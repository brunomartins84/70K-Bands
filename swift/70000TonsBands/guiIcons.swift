//
//  guiIcons.swift
//  70000TonsBands
//
//  Created by Ron Dorn on 1/13/15.
//  Copyright (c) 2015 Ron Dorn. All rights reserved.
//

import Foundation
import UIKit

let mustSeeIcon = "🍺"
let willSeeIcon = "✅"
let willNotSeeIcon = "🚫"
let unknownIcon = "❓"
let refreshIcon = "🔄"
let scheduleIcon = "⏰"
let poolVenue = "🏊"
let theaterVenue = "🎭"
let loungeVenue = "🎤"
let rinkVenue = "⛸"
let unknownVenue = "❓"
let bandIconSort = "🔠"

let showTypeIcon = "";
let specialEventTypeIcon = "🌟";
let mAndmEventTypeIcon = "📸";
let listeningEventTypeIcon = "💽";
let clinicEventTypeIcon = "🎸";
let unofficalEventTypeIcon = "👹";

//shows attended
let sawAllIcon = "🤘"
let sawSomeIcon = "👍"
let sawNoneIcon = ""
let attendedShowIcon = "🎟"

func getEventTypeIcon (_ eventType: String) -> String {

    switch eventType {
    case showType:
        return showTypeIcon
        
    case meetAndGreetype:
        return mAndmEventTypeIcon
        
    case specialEventType:
        return specialEventTypeIcon
        
    case clinicType:
        return clinicEventTypeIcon

    case listeningPartyType:
        return listeningEventTypeIcon
    
    case unofficalEventType:
        return unofficalEventTypeIcon

    case unofficalEventTypeOld:
        return unofficalEventTypeIcon
        
    default:
        return unknownVenue
    }
}

func getRankGuiIcons (rank: String)->UIImage {
   
    var graphicName = String()
    var graphicImage = UIImage()
    
    switch rank {
    case "must":
        graphicName = "MustSeeIcon"

    case "might":
        graphicName = "MightSeeIcon-1"

    case "wont":
        graphicName = "WontSeeIcon"
        
    case "mustAlt":
        graphicName = "MustSeeIcon"
        
    case "mightAlt":
        graphicName = "MightSeeIcon-1"
        
    case "wontAlt":
        graphicName = "WontSeeIcon"
        
    default:
        graphicName = ""
    }
    
    graphicImage = UIImage(named: graphicName) ?? UIImage()
    
    if (rank == "mustAlt" || rank == "mightAlt" || rank == "wontAlt"){
        graphicImage = invertImage(imageValue: graphicImage)
    }
    
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
        return willSeeIcon
        
    case 3:
        return willNotSeeIcon
        
    default:
        return ""
    }
}

func getPriorityGraphic(_ index: Int) -> String {

    switch index {
    case 1:
        return "MustSeeIcon"
        
    case 2:
        return "MightSeeIcon-1"
        
    case 3:
        return "WontSeeIcon"
        
    default:
        return ""
    }
}

func getBandIconSort() -> String {
   return bandIconSort
}

func getScheduleIcon() -> String {
    
    if (getSortedBy() == "name"){
        return scheduleIcon
    
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
    return willSeeIcon
}

func getWillNotSeeIcon  () -> String {
    return willNotSeeIcon
}

func getUnknownIcon() -> String {
    return unknownIcon
}

func getRefreshIcon() -> String {
    return refreshIcon
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
