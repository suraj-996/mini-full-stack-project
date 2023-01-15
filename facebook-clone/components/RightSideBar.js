import React from 'react'
import { RiVideoAddFill } from 'react-icons/ri'
import {BiSearch} from "react-icons/bi"
import {CgMoreAlt} from "react-icons/cg"
import Contacts from './Contacts'
const RightSideBar = () => {
  return (
    <div className='hidden md:inline-flex flex-col pt-4 max-w-xl md:min-w-[200px] lg:min-w-[250px]'>
        <div className="flex items-center text-gray-500">
            <p className="flex text-lg font-semibold flex-grow">Contacts</p>
            <div className="flex space-x-1 px-2">
                <div className="rounded-full p-2 hover:bg-gray-200 cursor-pointer">
                    <RiVideoAddFill/>
                </div>
                <div className="rounded-full p-2 hover:bg-gray-200 cursor-pointer">
                    <BiSearch/>
                </div>
                <div className="rounded-full p-2 hover:bg-gray-200 cursor-pointer">
                    <CgMoreAlt/>
                </div>
            </div>
        </div>
        <Contacts src="https://images.pexels.com/photos/14318107/pexels-photo-14318107.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load" name="Emma Watson" status="Online"/>
        <Contacts src="https://images.pexels.com/photos/1043474/pexels-photo-1043474.jpeg?auto=compress&cs=tinysrgb&w=300" name="Johnny Depp" status="Offline"/>
        <Contacts src="https://images.pexels.com/photos/2681751/pexels-photo-2681751.jpeg?auto=compress&cs=tinysrgb&w=300" name="Anne Hathaway" status="Online"/>
        <Contacts src="https://images.pexels.com/photos/775358/pexels-photo-775358.jpeg?auto=compress&cs=tinysrgb&w=300" name="Jennifer Lawrence" status="Offline"/>
        <Contacts src="https://images.pexels.com/photos/4153141/pexels-photo-4153141.jpeg?auto=compress&cs=tinysrgb&w=300" name="Alexandra Daddario" status="Online"/>
    </div>
  )
}

export default RightSideBar
