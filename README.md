# ChatSystem

![Version](https://img.shields.io/badge/Minecraft-1.20.x-brightgreen)
![License](https://img.shields.io/badge/License-MIT-blue)

A lightweight yet powerful chat enhancement plugin for Bukkit/Spigot/Paper Minecraft servers.

## 📋 Features

- ✅ **User Mentions**: Mention players with @ and highlight their names
- ✅ **Notification Sounds**: Play sounds when a player is mentioned
- ✅ **Custom Chat Format**: Fully customizable chat message format
- ✅ **RGB/HEX Color Support**: Use modern color codes and gradients
- ✅ **LuckPerms Integration**: Display player prefixes and suffixes
- ✅ **Important Users**: Make messages from staff stand out
- ✅ **Reload Command**: Reload configuration with `/creload`

## 🚀 Quick Start

1. Download the latest release [here](https://github.com/FemRene/ChatSystem/releases/latest/download/ChatSystem.jar)
2. Place the JAR file in your server's `plugins` folder
3. Restart your server
4. Edit the configuration file at `plugins/ChatSystem/config.yml` if needed

## 📖 Documentation

For detailed information about configuration, permissions, commands, and more, please see the [Documentation](DOCUMENTATION.md).

## 🔧 Commands

| Command | Permission | Description |
|---------|------------|-------------|
| `/creload` | `chatsystem.reload` | Reloads the plugin configuration |

## 🔒 Permissions

| Permission | Description |
|------------|-------------|
| `chat.write` | Allows a player to write in chat |
| `chat.important` | Makes the player's messages stand out with empty lines before and after |
| `chatsystem.reload` | Allows use of the reload command |

## ⚙️ Configuration

Basic configuration example:

```yaml
# Chat formatting
arrow: <#555555>»
msg: '%prefix %arrow <#AAAAAA>%player %suffix: <reset>%message'
mentionMessage: <#55FFFF>@%player<reset>

# LuckPerms integration
useMetaKeyAsPrefix: false
metaPrefixString: META-KEY
useMetaKeyAsSuffix: false
metaSuffixString: META-KEY

# Mention settings
pingSound: true
```

For more configuration options and detailed explanations, see the [Documentation](DOCUMENTATION.md).

## 🔌 API

An API for developers is planned for future releases. Check the [TODO list](TODO.md) for upcoming features.

## 🤝 [Contributing](CONTRIBUTING.md)

Contributions are welcome! Check out our [TODO list](TODO.md) for planned features and improvements.

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m 'Add some amazing feature'`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

## 📜 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Support

If you encounter any issues or have questions, please [open an issue](https://github.com/FemRene/ChatSystem/issues) on GitHub.