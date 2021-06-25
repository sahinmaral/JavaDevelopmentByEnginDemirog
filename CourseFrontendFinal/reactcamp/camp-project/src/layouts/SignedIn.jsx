import React from 'react'
import { Menu ,Image , Dropdown} from 'semantic-ui-react'

//props yerine gelen objeyi destruct ederek tekil bir şekilde alınabilir
export default function SignedIn({signOut}) {
    return (
        <div>
            <Menu.Item>
                <Image avatar spaced="right" src="https://yt3.ggpht.com/yti/ANoDKi7Rh-MCpmRge-z97eUFSfCTX6Am1fVnIOpTVdOPdw=s88-c-k-c0x00ffffff-no-rj-mo" />
                <Dropdown pointing="top right" text="Şahin">
                    <Dropdown.Menu>
                        <Dropdown.Item text="Bilgilerim" icon="info" />
                        <Dropdown.Item text="Çıkış yap" icon="sign-out" onClick={signOut} />
                    </Dropdown.Menu>
                </Dropdown>
            </Menu.Item>
        </div>
    )
}
