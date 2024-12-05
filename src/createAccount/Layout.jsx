import React from 'react'
import {Outlet} from "react-router-dom"
import Navbar from '../component/Bar/Navbar'

function Layout() {
  return (
    <div>
        <Navbar/>
        <Outlet/>
    </div>
  )
}

export default Layout