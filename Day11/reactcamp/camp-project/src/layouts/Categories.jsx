import React from 'react'
import { Input, Label, Menu } from 'semantic-ui-react'

export default function Categories() {
    return (
        <div>
           <Menu pointing vertical>
        <Menu.Item
          name='home'
        />
        <Menu.Item
          name='messages'
        />
        <Menu.Item
          name='friends'
        />
      </Menu>
        </div>
    )
}
